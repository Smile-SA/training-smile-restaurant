
package com.smile.plugins.portlet.indexer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.ratings.model.RatingsStats;
import com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil;
import com.smile.plugins.Permissions.RestaurantPermission;
import com.smile.plugins.constants.PortletKeys;
import com.smile.plugins.model.Restaurant;
import com.smile.plugins.service.RestaurantLocalServiceUtil;
import com.smile.plugins.service.persistence.RestaurantActionableDynamicQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

/**
 * Indexer
 *
 */
public class RestaurantIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {
		Restaurant.class.getName()
	};

	public static final String PORTLET_ID = PortletKeys.MEAT_TIME_PORTLET;

	public RestaurantIndexer() {

		setPermissionAware(true);
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId)
		throws Exception {

		return RestaurantPermission.contains(permissionChecker, entryClassPK, ActionKeys.VIEW);
	}

	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	@Override
	protected void doDelete(Object obj)
		throws Exception {

		Restaurant restaurant = (Restaurant) obj;
		deleteDocument(restaurant.getCompanyId(), restaurant.getRestaurantId());
	}

	@Override
	protected Document doGetDocument(Object obj)
		throws Exception {

		Restaurant restaurant = (Restaurant) obj;
		int commentsCount = 0;
		double ratingsCount = 0;
		if (restaurant != null && !restaurant.isNew()) {
			commentsCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(Restaurant.class.getName(), restaurant.getRestaurantId(), WorkflowConstants.STATUS_APPROVED);
			RatingsStats ratingsStats = RatingsStatsLocalServiceUtil.getStats(Restaurant.class.getName(), restaurant.getRestaurantId());
			ratingsCount = ratingsStats.getAverageScore();
		}

		Document document = getBaseModelDocument(PORTLET_ID, restaurant);

		document.addDate(Field.MODIFIED_DATE, restaurant.getModifiedDate());
		document.addDate(Field.CREATE_DATE, restaurant.getCreateDate());
		document.addLocalizedKeyword(Field.TITLE, restaurant.getNameMap());
		document.addKeyword("restaurantId", restaurant.getRestaurantId());

		document.addNumber(Field.COMMENTS, commentsCount);
		document.addNumber(Field.RATINGS, ratingsCount);

		return document;
	}

	@Override
	protected void doReindex(Object obj)
		throws Exception {

		Restaurant restaurant = (Restaurant) obj;
		Document document = getDocument(restaurant);

		SearchEngineUtil.updateDocument(getSearchEngineId(), restaurant.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		Restaurant restaurant = RestaurantLocalServiceUtil.getRestaurant(classPK);

		doReindex(restaurant);
	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId)
		throws PortalException, SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new RestaurantActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {

			}

			@Override
			protected void performAction(Object object)
				throws PortalException {

				Restaurant artist = (Restaurant) object;

				Document document = getDocument(artist);

				documents.add(document);
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		return PORTLET_ID;
	}

	public Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) {

		String title = document.get(locale, Field.TITLE);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = document.get(Field.DESCRIPTION);

			if (Validator.isNull(content)) {
				content = StringUtil.shorten(document.get(Field.CONTENT), 200);
			}
		}

		String resourcePrimKey = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("action", "full_content");
		portletURL.setParameter("resourcePrimKey", resourcePrimKey);

		return new Summary(title, content, null);
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		if (searchContext.getAttributes() == null) {
			return;
		}

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, true);
	}

	@Override
	public void postProcessContextQuery(BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {

		addStatus(contextQuery, searchContext);

		int restaurantId = GetterUtil.getInteger(searchContext.getAttribute("restaurantId"));
	

		if (restaurantId != 0) {
			contextQuery.addRequiredTerm("restaurantId", restaurantId);
		}
		
	}

	@Override
	protected void addSearchAssetCategoryIds(BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {

		addSearchAnyCategories(contextQuery, searchContext);

	}

	@Override
	public String getPortletId() {

		return PORTLET_ID;
	}

	protected void addSearchAnyCategories(BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {

		long[] anyCategoryIds = searchContext.getAssetCategoryIds();

		if (anyCategoryIds.length == 0) {
			return;
		}

		BooleanQuery categoryIdsQuery = BooleanQueryFactoryUtil.create(searchContext);

		for (long anyCategoryId : anyCategoryIds) {
			AssetCategory assetCategory = AssetCategoryLocalServiceUtil.fetchAssetCategory(anyCategoryId);

			if (assetCategory == null) {
				continue;
			}

			List<Long> categoryIds = new ArrayList<Long>();

			categoryIds = AssetCategoryLocalServiceUtil.getSubcategoryIds(anyCategoryId);

			if (categoryIds.isEmpty()) {
				categoryIds.add(anyCategoryId);
			}

			for (long categoryId : categoryIds) {
				categoryIdsQuery.addTerm(Field.ASSET_CATEGORY_IDS, categoryId);
			}
		}

		contextQuery.add(categoryIdsQuery, BooleanClauseOccur.MUST);
	}
}
