package com.smile.plugins.portlet.validator;

import com.liferay.portal.kernel.util.Validator;
import com.smile.plugins.model.Restaurant;
import com.smile.plugins.portlet.util.RestaurantImageUtil;

import java.util.List;
import java.util.Locale;


/**
 * @author guillaumelenoir
 * Restaurant validator
 * 
 */
public class RestaurantValidator {
	
	/**
	 * Singleton... improve this !
	 */
	private RestaurantValidator() {
		super();
	}

	/**
	 * @param restaurant
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 * @return
	 */
	public static boolean validateRestaurant(Restaurant restaurant, List<String> errors, Locale locale) {

		boolean valid = true;

		if (Validator.isNull(restaurant)) {
			errors.add("restaurant-errors");
			valid = false;
		}
		
		if (!Validator.isEmailAddress(restaurant.getEmailAddress())) {
			errors.add("restaurant-emailAddress-required");
			valid = false;
		}
		
		if (Validator.isBlank(restaurant.getName(locale))) {
			errors.add("restaurant-name-required");
			valid = false;
		}
		
		if (Validator.isNull(restaurant)) {
			errors.add("restaurant-errors");
			valid = false;
		}
		
		if (!Validator.isPhoneNumber(restaurant.getPhoneNumber())) {
			errors.add("restaurant-phoneNumber-required");
			valid = false;
		}
		
		if (Validator.isBlank(restaurant.getZip()) || !(restaurant.getZip().length() > 2)) {
			errors.add("restaurant-zip-required");
			valid = false;
		}
		
		if (Validator.isBlank(restaurant.getStreet1()) || !(restaurant.getStreet1().length() > 2)) {
			errors.add("restaurant-street1-required");
			valid = false;
		}
		
		if (Validator.isBlank(restaurant.getStreet2()) || !(restaurant.getStreet2().length() > 2)) {
			errors.add("restaurant-street2-required");
			valid = false;
		}
		
		if (Validator.isBlank(restaurant.getCity()) || !(restaurant.getCity().length() > 2)) {
			errors.add("restaurant-city-required");
			valid = false;
		}
		
		// Image processing :)
		if (Validator.isNotNull(restaurant.getLogoInputStream())) {
			restaurant.setLogoInputStream(RestaurantImageUtil.resizeImages(restaurant.getLogoInputStream()));
		}
		
		return valid;
	}
}
