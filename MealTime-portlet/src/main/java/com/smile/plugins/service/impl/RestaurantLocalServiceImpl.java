package com.smile.plugins.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.Repository;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.smile.plugins.constants.RestaurantConstants;
import com.smile.plugins.model.Restaurant;
import com.smile.plugins.service.base.RestaurantLocalServiceBaseImpl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

/**
 * The implementation of the restaurant local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.smile.plugins.service.RestaurantLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guillaume Lenoir
 * @see com.smile.plugins.service.base.RestaurantLocalServiceBaseImpl
 * @see com.smile.plugins.service.RestaurantLocalServiceUtil
 */
public class RestaurantLocalServiceImpl extends RestaurantLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.smile.plugins.service.RestaurantLocalServiceUtil} to access the restaurant local service.
     */
	
	/**
	 * RestaurantLocalServiceImpl Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RestaurantLocalServiceImpl.class);
	
	public Restaurant addRestaurant(Restaurant restaurant, ServiceContext serviceContext) throws SystemException, PortalException {
		long restaurantId = CounterLocalServiceUtil.increment(Restaurant.class.getName());
		
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		restaurant.setCompanyId(companyId);
		restaurant.setGroupId(groupId);
		restaurant.setRestaurantId(restaurantId);
		restaurant.setUserId(userId);

		Date now = DateTime.now().toDate();
		
		restaurant.setStatus(WorkflowConstants.STATUS_DRAFT);
		restaurant.setUuid(serviceContext.getUuid());
		restaurant.setModifiedDate(now);
		restaurant.setCreateDate(now);
		restaurant.setUserName(userLocalService.getUser(userId).getFullName());
		
		// Create restaurant
		
		// Update Image
		InputStream inputStream = restaurant.getLogoInputStream();
		
		updateImage(restaurant, groupId, userId, inputStream);
		
		// Persistence
		restaurantPersistence.update(restaurant);
		
		// Resources
		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			resourceLocalService.addResources(
				companyId, groupId, userId,
				Restaurant.class.getName(), restaurantId, false,
				serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}
		else {
			resourceLocalService.addModelResources(
				companyId, groupId, userId,
				Restaurant.class.getName(), restaurantId, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}
		
		// Asset
		updateAsset(
			userId, restaurant, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(),
			serviceContext.getAssetLinkEntryIds());
		
		// Message boards
		mbMessageLocalService.addDiscussionMessage(
			userId, restaurant.getUserName(), groupId,
			Restaurant.class.getName(), restaurant.getRestaurantId(),
			WorkflowConstants.ACTION_PUBLISH);
		
		// Workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
			restaurant.getCompanyId(), restaurant.getGroupId(), serviceContext.getUserId(),
			Restaurant.class.getName(), restaurant.getPrimaryKey(), restaurant,
			serviceContext);
		
		return restaurant;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Restaurant updateRestaurant(Restaurant restaurant, ServiceContext serviceContext) throws PortalException, SystemException {

		// Set modified Date
		Date now = DateTime.now().toDate();
		restaurant.setModifiedDate(now);
		
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		restaurant.setCompanyId(companyId);
		restaurant.setGroupId(groupId);
		restaurant.setUserId(userId);
		
		// Asset
		updateAsset(restaurant.getUserId(), restaurant, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), serviceContext.getAssetLinkEntryIds());
		
		// Update Image
		InputStream inputStream = restaurant.getLogoInputStream();
		
		updateImage(restaurant, groupId, userId, inputStream);
		
		return super.updateRestaurant(restaurant);
	}
	
	public Restaurant deleteRestaurant(long restaurantId) throws PortalException, SystemException {
		Restaurant restaurant = restaurantPersistence.findByPrimaryKey(restaurantId);

		// Asset
		assetEntryLocalService.deleteEntry(
			Restaurant.class.getName(), restaurantId);
		
		// Indexer
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			Restaurant.class);

		indexer.delete(restaurant);

		// Delete logo

		if (Validator.isNotNull(restaurant.getLogoId())) {
			try {
				PortletFileRepositoryUtil.deletePortletFileEntry(
					restaurant.getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					String.valueOf(restaurant.getRestaurantId()));
			}
			catch (Exception e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
					LOGGER.debug("Cannot delete logo image");
				}
			}
		}
		
		// Workflow
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			restaurant.getCompanyId(), restaurant.getGroupId(),
			Restaurant.class.getName(), restaurant.getRestaurantId());
		
		// Message boards
		mbMessageLocalService.deleteDiscussionMessages(Restaurant.class.getName(), restaurantId);
				
		// Resources
		resourceLocalService.deleteResource(restaurant.getCompanyId(), Restaurant.class.getName(), ResourceConstants.SCOPE_COMPANY, restaurant.getPrimaryKey());
		
		return super.deleteRestaurant(restaurantId);
	}
	
	
	public void updateAsset(
		long userId, Restaurant restaurant, long[] assetCategoryIds,
		String[] assetTagNames, long[] assetLinkEntryIds)
	throws PortalException, SystemException {

		AssetEntryLocalServiceUtil.updateEntry(
			userId, restaurant.getGroupId(), restaurant.getCreateDate(),
			restaurant.getModifiedDate(), Restaurant.class.getName(), restaurant.getRestaurantId(),
			restaurant.getUuid(), 0, assetCategoryIds, assetTagNames, true, null,
			null, null, ContentTypes.TEXT_HTML, restaurant.getName(), StringPool.BLANK, null,
			null, StringPool.BLANK, 0, 0, null, false);
		
	}
	
	public List<Restaurant> getRestaurantByGroupId (long groupId) throws SystemException {
		return restaurantPersistence.findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}
	
	public List<Restaurant> getRestaurantByGroupId (long groupId, int start, int end) throws SystemException {
		return restaurantPersistence.findByGroupId(groupId, start, end, null);
	}
	
	public List<Restaurant> getRestaurantByGroupId (long groupId, int start, int end, OrderByComparator orderByComparator) throws SystemException {
		return restaurantPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	
	public int getRestaurantsCountByGroupId (long groupId) throws SystemException {
		return restaurantPersistence.countByGroupId(groupId);
	}
	
	private void updateImage(Restaurant restaurant, long groupId, long userId, InputStream inputStream)
		throws PortalException, SystemException {

		if (Validator.isNotNull(inputStream)) {

			if (restaurant.getLogoId() != 0) {

				Repository repository =
								PortletFileRepositoryUtil.fetchPortletRepository(
								groupId,
								RestaurantConstants.RESTAURANT_PORTLET_REPOSITORY);
				
				try {
					// Delete old file Entry
					PortletFileRepositoryUtil.deletePortletFileEntry(
						repository.getRepositoryId(),
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						String.valueOf(restaurant.getRestaurantId()));
				}
				catch (Exception e) {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(e);
						LOGGER.debug("Cannot delete logo image");
					}
					LOGGER.error(e);
				}
			}

			FileEntry fileEntry =
							PortletFileRepositoryUtil.addPortletFileEntry(
								groupId, userId,
								Restaurant.class.getName(), restaurant.getRestaurantId(),
								RestaurantConstants.RESTAURANT_PORTLET_REPOSITORY,
								DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, inputStream,
								String.valueOf(restaurant.getRestaurantId()), StringPool.BLANK, true);

			restaurant.setLogoId(fileEntry.getFileEntryId());
		}
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Restaurant updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		Restaurant restaurant = getRestaurant(resourcePrimKey);

		restaurant.setStatus(status);
		restaurant.setStatusByUserId(userId);
		restaurant.setStatusByUserName(user.getFullName());
		restaurant.setStatusDate(serviceContext.getModifiedDate());

		updateRestaurant(restaurant);

		if (status == WorkflowConstants.STATUS_APPROVED) {

			assetEntryLocalService.updateVisible(Restaurant.class.getName(), resourcePrimKey, true);

		}
		else {

			assetEntryLocalService.updateVisible(Restaurant.class.getName(), resourcePrimKey, false);
		}

		return restaurant;
	}
}
