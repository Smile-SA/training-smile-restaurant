package com.smile.plugins.portlet.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.smile.plugins.Permissions.RestaurantPermission;
import com.smile.plugins.constants.PortletKeys;
import com.smile.plugins.model.Restaurant;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;


public class RestaurantAssetRenderer extends BaseAssetRenderer {

	protected static Log LOGGER = LogFactoryUtil.getLog(RestaurantAssetRenderer.class);
	
	public RestaurantAssetRenderer(Restaurant restaurant) {
		_restaurant = restaurant;
	}
	
	public String getPortletId() {
		AssetRendererFactory assetRendererFactory = getAssetRendererFactory();
		return assetRendererFactory.getPortletId();
	}
	
	public boolean hasDeletePermission(PermissionChecker permissionChecker)
	throws PortalException, SystemException {

	return RestaurantPermission.contains(permissionChecker, _restaurant.getRestaurantId(), ActionKeys.DELETE);
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {
	
		return RestaurantPermission.contains(permissionChecker, _restaurant.getRestaurantId(), ActionKeys.UPDATE);
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {
	
		return RestaurantPermission.contains(permissionChecker, _restaurant.getRestaurantId(), ActionKeys.VIEW);
		
	}
	
	@Override
	public boolean isPrintable() {
		return true;
	}
	@Override
	public long getGroupId() {

		return _restaurant.getGroupId();
	}

	@Override
	public long getUserId() {

		return _restaurant.getUserId();
	}

	@Override
	public String getUserName() {

		return _restaurant.getUserName();
	}

	@Override
	public String getUuid() {

		return _restaurant.getUuid();
	}

	@Override
	public String getClassName() {

		return Restaurant.class.getName();
	}

	@Override
	public long getClassPK() {

		return _restaurant.getRestaurantId();
	}

	@Override
	public String getSummary(Locale locale) {

		String summary = _restaurant.getDescription(locale);

		return HtmlUtil.stripHtml(StringUtil.shorten(HtmlUtil.stripHtml(summary), 200));
	}

	@Override
	public String getTitle(Locale locale) {

		return _restaurant.getName(locale);
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if (template.equals(TEMPLATE_FULL_CONTENT) || template.equals(TEMPLATE_ABSTRACT)) {
						
			renderRequest.setAttribute("restaurant", _restaurant);
			renderRequest.setAttribute("description", getSummary(themeDisplay.getLocale()));
			
			return "/html/restaurants/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	@Override
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws PortalException, SystemException {
		
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			getControlPanelPlid(liferayPortletRequest),
			PortletKeys.MEAT_TIME_PORTLET, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("jspPage", "/html/restaurants/edit.jsp");
		portletURL.setParameter("restaurantId", String.valueOf(_restaurant.getRestaurantId()));
		
		return portletURL;
	}
	
	@Override
	public PortletURL getURLView(
			LiferayPortletResponse liferayPortletResponse,
			WindowState windowState) throws WindowStateException {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			PortletKeys.MEAT_TIME_PORTLET, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("jspPage", "/html/restaurants/edit.jsp");
		portletURL.setParameter("restaurantId", String.valueOf(_restaurant.getRestaurantId()));
		portletURL.setWindowState(windowState);

		return portletURL;
	}
	@Override
	public String getDiscussionPath() {
			return "edit_entry_discussion";
	}
	
	@Override
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect) throws WindowStateException, PortalException, SystemException {

		try {
			long plid = PortalUtil.getPlidFromPortletId(
				_restaurant.getGroupId(), PortletKeys.MEAT_TIME_PORTLET);

			if (plid == LayoutConstants.DEFAULT_PLID) {
				return StringPool.BLANK;
			}

			PortletURL portletURL = PortletURLFactoryUtil.create(
				liferayPortletRequest, PortletKeys.MEAT_TIME_PORTLET, plid,
				PortletRequest.RENDER_PHASE);

			portletURL.setParameter("jspPage", "/html/restaurants/asset/full_content.jsp");
			portletURL.setParameter(
				"restaurantId", String.valueOf(_restaurant.getRestaurantId()));

			return portletURL.toString();
		}
		catch (Exception e) {
		}

		return StringPool.BLANK;
	}

	private Restaurant _restaurant;
}
