
package com.smile.plugins.portlet.restaurant;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.smile.plugins.Permissions.RestaurantsPermission;
import com.smile.plugins.model.Restaurant;
import com.smile.plugins.portlet.validator.RestaurantValidator;
import com.smile.plugins.service.RestaurantLocalServiceUtil;
import com.smile.plugins.service.RestaurantServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class RestaurantController extends MVCPortlet {

	/**
	 * RestaurantController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RestaurantController.class);

	/**
	 * Empty Results Message
	 */
	private String emptyResultsMessage = "restaurant-empty-results-message";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		System.out.println("doview");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL iteratorURL = renderResponse.createRenderURL();

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);

		// Todo
		boolean hasAddRight = RestaurantsPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), "ADD_RESTAURANT");

		// create search container
		SearchContainer<Restaurant> searchRestaurantContainer =
			new SearchContainer<Restaurant>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, cur, delta, iteratorURL, null, emptyResultsMessage);

		int start = searchRestaurantContainer.getStart();
		int end = searchRestaurantContainer.getEnd();
		long groupId = themeDisplay.getScopeGroupId();

		// Get restaurants
		try {
			List<Restaurant> restaurants = RestaurantLocalServiceUtil.getRestaurantByGroupId(groupId, start, end);
			int total = RestaurantLocalServiceUtil.getRestaurantsCountByGroupId(themeDisplay.getScopeGroupId());
			searchRestaurantContainer.setTotal(total);
			searchRestaurantContainer.setResults(restaurants);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to build searchRestaurantContainer");
		}

		renderRequest.setAttribute("searchRestaurantContainer", searchRestaurantContainer);

		renderRequest.setAttribute("hasAddRight", hasAddRight);

		super.doView(renderRequest, renderResponse);
	}

	
	@Override
	public void init()
		throws PortletException {

		System.out.println("init");
		super.init();
	}


	@Override
	public void destroy() {

		System.out.println("destroy");
		super.destroy();
	}


	/**
	 * Add Restaurant
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void addRestaurant(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Restaurant restaurant = null;
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			restaurant = restaurantFromRequest(uploadPortletRequest, themeDisplay);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Restaurant.class.getName(), uploadPortletRequest);

			ArrayList<String> errors = new ArrayList<String>();

			if (RestaurantValidator.validateRestaurant(restaurant, errors, themeDisplay.getLocale())) {
				RestaurantServiceUtil.addRestaurant(restaurant, serviceContext);
				SessionMessages.add(actionRequest, "restaurant-added");

				sendRedirect(actionRequest, actionResponse);
			}
			else {
				for (String error : errors) {
					SessionErrors.add(actionRequest, error);
				}

				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				actionResponse.setRenderParameter("jspPage", "/html/restaurants/edit.jsp");
			}
		}
		catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("Exception: unable to get add restaurant");

			SessionErrors.add(actionRequest, "restaurant-errors");
		}

	}

	/**
	 * Update Restaurant
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void updateRestaurant(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Restaurant restaurant = null;
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			restaurant = restaurantFromRequest(uploadPortletRequest, themeDisplay);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Restaurant.class.getName(), uploadPortletRequest);

			ArrayList<String> errors = new ArrayList<String>();

			if (RestaurantValidator.validateRestaurant(restaurant, errors, themeDisplay.getLocale())) {
				RestaurantServiceUtil.updateRestaurant(restaurant, serviceContext);
				SessionMessages.add(actionRequest, "restaurant-updated");

				sendRedirect(actionRequest, actionResponse);
			}
			else {
				for (String error : errors) {
					SessionErrors.add(actionRequest, error);
				}

				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				actionResponse.setRenderParameter("jspPage", "/html/restaurants/edit.jsp");
			}
		}
		catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("Exception: unable to updated restaurant");

			SessionErrors.add(actionRequest, "restaurant-errors");
		}
	}

	/**
	 * Delete Restaurant
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void deleteRestaurant(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {
		
		long restaurantId = ParamUtil.getLong(actionRequest, "restaurantId");
		try {
			
			RestaurantLocalServiceUtil.deleteRestaurant(restaurantId);
			SessionMessages.add(actionRequest, "restaurant-deleted");
		}
		catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("Exception: unable to delete restaurant " + restaurantId);

			SessionErrors.add(actionRequest, "restaurant-errors");
		}
		
	}

	private Restaurant restaurantFromRequest(UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		Restaurant restaurant = null;
		Map<Locale, String> descriptionMap = null;
		
		long restaurantId = ParamUtil.getLong(uploadPortletRequest, "restaurantId");

		if (Validator.isNotNull(restaurantId)) {
			restaurant = RestaurantLocalServiceUtil.getRestaurant(restaurantId);
			descriptionMap = restaurant.getDescriptionMap();
		}
		else {
			restaurant = RestaurantLocalServiceUtil.createRestaurant(restaurantId);
			descriptionMap = new HashMap<Locale, String>();
		}

		String emailAddress = ParamUtil.getString(uploadPortletRequest, "emailAddress");
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(uploadPortletRequest, "name");

		long countryId = ParamUtil.getLong(uploadPortletRequest, "countryId");
		long regionId = ParamUtil.getLong(uploadPortletRequest, "regionId");

		String phoneNumber = ParamUtil.getString(uploadPortletRequest, "phoneNumber");
		String city = ParamUtil.getString(uploadPortletRequest, "city");
		String zip = ParamUtil.getString(uploadPortletRequest, "zip");
		String street1 = ParamUtil.getString(uploadPortletRequest, "street1");
		String street2 = ParamUtil.getString(uploadPortletRequest, "street2");
		Map<Locale, String> logoDescriptionMap = LocalizationUtil.getLocalizationMap(uploadPortletRequest, "logoDescription");
		
		String content = ParamUtil.getString(uploadPortletRequest, "editor");
		
		
		descriptionMap.put(themeDisplay.getLocale(), content);

		Map<String, FileItem[]> multipartParameterMap = uploadPortletRequest.getMultipartParameterMap();
		InputStream inputStream = null;

		if (multipartParameterMap.keySet().contains("logo")) {
			try {
				inputStream = uploadPortletRequest.getFileAsStream("logo");
			}
			catch (IOException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("IOException : unable to logo file as Stream");
			}
		}

		// Projection
		restaurant.setEmailAddress(emailAddress);
		restaurant.setNameMap(nameMap);
		restaurant.setCountryId(countryId);
		restaurant.setRegionId(regionId);

		restaurant.setPhoneNumber(phoneNumber);
		restaurant.setZip(zip);
		restaurant.setStreet1(street1);
		restaurant.setStreet2(street2);
		restaurant.setDescriptionMap(descriptionMap);
		restaurant.setLogoDescriptionMap(logoDescriptionMap);
		restaurant.setLogoInputStream(inputStream);
		restaurant.setCity(city);

		return restaurant;
	}

}
