package com.smile.plugins.portlet.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.smile.plugins.Permissions.RestaurantPermission;
import com.smile.plugins.Permissions.RestaurantsPermission;
import com.smile.plugins.constants.PortletKeys;
import com.smile.plugins.model.Restaurant;
import com.smile.plugins.service.RestaurantLocalServiceUtil;

import javax.portlet.PortletURL;


public class RestaurantAssetRendererFactory extends BaseAssetRendererFactory{

	public static final String CLASS_NAME = Restaurant.class.getName();

	public static final String TYPE = "restaurant";

	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		Restaurant restaurant = RestaurantLocalServiceUtil.getRestaurant(classPK);

		return new RestaurantAssetRenderer(restaurant);
	}
	
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}
	
	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return RestaurantPermission.contains(permissionChecker, classPK, actionId);
	}
	
	@Override
	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

		if (!RestaurantsPermission.contains(
				themeDisplay.getPermissionChecker(),
				themeDisplay.getScopeGroupId(), "ADD_RESTAURANT")) {

			return null;
		}

		PortletURL portletURL = liferayPortletResponse.createRenderURL(
			PortletKeys.MEAT_TIME_PORTLET);

		portletURL.setParameter("jspPage", "/html/restaurants/edit.jsp");

		return portletURL;
	}

	private static final boolean _LINKABLE = true;
}
