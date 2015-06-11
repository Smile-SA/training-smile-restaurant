package com.smile.plugins.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.smile.plugins.Permissions.RestaurantPermission;
import com.smile.plugins.Permissions.RestaurantsPermission;
import com.smile.plugins.model.Restaurant;
import com.smile.plugins.service.base.RestaurantServiceBaseImpl;

/**
 * The implementation of the restaurant remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.smile.plugins.service.RestaurantService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guillaume Lenoir
 * @see com.smile.plugins.service.base.RestaurantServiceBaseImpl
 * @see com.smile.plugins.service.RestaurantServiceUtil
 */
public class RestaurantServiceImpl extends RestaurantServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.smile.plugins.service.RestaurantServiceUtil} to access the restaurant remote service.
     */
	
	public Restaurant addRestaurant (Restaurant restaurant, ServiceContext serviceContext) throws PrincipalException, PortalException, SystemException {
		RestaurantsPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_RESTAURANT");
		
		return restaurantLocalService.addRestaurant(restaurant, serviceContext);
		
	}
	
	public Restaurant updateRestaurant (Restaurant restaurant, ServiceContext serviceContext) throws PrincipalException, PortalException, SystemException {
		RestaurantPermission.check(getPermissionChecker(), restaurant.getRestaurantId(), ActionKeys.UPDATE);
		
		return restaurantLocalService.updateRestaurant(restaurant, serviceContext);
		
	}
	
	public Restaurant deleteRestaurant (long restaurantId)
		throws SystemException, PrincipalException, PortalException {

		RestaurantPermission.check(getPermissionChecker(), restaurantId, ActionKeys.DELETE);

		return restaurantLocalService.deleteRestaurant(restaurantId);
	}
}
