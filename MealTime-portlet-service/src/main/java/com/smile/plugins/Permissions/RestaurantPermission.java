package com.smile.plugins.Permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.smile.plugins.constants.PortletKeys;
import com.smile.plugins.model.Restaurant;
import com.smile.plugins.service.RestaurantLocalServiceUtil;


/**
 * @author guillaumelenoir
 *
 */
public class RestaurantPermission {
	
	/**
	 * @param permissionChecker
	 * @param Restaurant
	 * @param actionId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void check(PermissionChecker permissionChecker, Restaurant Restaurant, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, Restaurant, actionId)) {
			throw new PrincipalException();
		}
	}

	/**
	 * @param permissionChecker
	 * @param RestaurantId
	 * @param actionId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void check(PermissionChecker permissionChecker, long RestaurantId, String actionId)
		throws PortalException, SystemException {

		Restaurant Restaurant = RestaurantLocalServiceUtil.getRestaurant(RestaurantId);

		check(permissionChecker, Restaurant, actionId);
	}

	/**
	 * @param permissionChecker
	 * @param restaurant
	 * @param actionId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static boolean contains(PermissionChecker permissionChecker, Restaurant restaurant, String actionId)
		throws PortalException, SystemException {

		Boolean hasPermission =
			StagingPermissionUtil.hasPermission(permissionChecker, restaurant.getGroupId(), Restaurant.class.getName(), restaurant.getRestaurantId(), PortletKeys.MEAT_TIME_PORTLET, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}
		
		// Owner ?
		if (permissionChecker.hasOwnerPermission(
			restaurant.getCompanyId(), Restaurant.class.getName(),
			restaurant.getRestaurantId(), restaurant.getUserId(), actionId)) {
	
		return true;
	}

		return permissionChecker.hasPermission(restaurant.getGroupId(), Restaurant.class.getName(), restaurant.getRestaurantId(), actionId);
	}

	/**
	 * @param permissionChecker
	 * @param RestaurantId
	 * @param actionId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static boolean contains(PermissionChecker permissionChecker, long RestaurantId, String actionId)
		throws PortalException, SystemException {

		Restaurant Restaurant = RestaurantLocalServiceUtil.getRestaurant(RestaurantId);

		return contains(permissionChecker, Restaurant, actionId);
	}

}
