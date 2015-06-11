package com.smile.plugins.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Restaurant}.
 * </p>
 *
 * @author guillaume Lenoir
 * @see Restaurant
 * @generated
 */
public class RestaurantWrapper implements Restaurant, ModelWrapper<Restaurant> {
    private Restaurant _restaurant;

    public RestaurantWrapper(Restaurant restaurant) {
        _restaurant = restaurant;
    }

    @Override
    public Class<?> getModelClass() {
        return Restaurant.class;
    }

    @Override
    public String getModelClassName() {
        return Restaurant.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("restaurantId", getRestaurantId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("status", getStatus());
        attributes.put("statusByUserId", getStatusByUserId());
        attributes.put("statusByUserName", getStatusByUserName());
        attributes.put("statusDate", getStatusDate());
        attributes.put("emailAddress", getEmailAddress());
        attributes.put("name", getName());
        attributes.put("countryId", getCountryId());
        attributes.put("regionId", getRegionId());
        attributes.put("phoneNumber", getPhoneNumber());
        attributes.put("street1", getStreet1());
        attributes.put("street2", getStreet2());
        attributes.put("zip", getZip());
        attributes.put("city", getCity());
        attributes.put("logoId", getLogoId());
        attributes.put("logoDescription", getLogoDescription());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long restaurantId = (Long) attributes.get("restaurantId");

        if (restaurantId != null) {
            setRestaurantId(restaurantId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long statusByUserId = (Long) attributes.get("statusByUserId");

        if (statusByUserId != null) {
            setStatusByUserId(statusByUserId);
        }

        String statusByUserName = (String) attributes.get("statusByUserName");

        if (statusByUserName != null) {
            setStatusByUserName(statusByUserName);
        }

        Date statusDate = (Date) attributes.get("statusDate");

        if (statusDate != null) {
            setStatusDate(statusDate);
        }

        String emailAddress = (String) attributes.get("emailAddress");

        if (emailAddress != null) {
            setEmailAddress(emailAddress);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Long countryId = (Long) attributes.get("countryId");

        if (countryId != null) {
            setCountryId(countryId);
        }

        Long regionId = (Long) attributes.get("regionId");

        if (regionId != null) {
            setRegionId(regionId);
        }

        String phoneNumber = (String) attributes.get("phoneNumber");

        if (phoneNumber != null) {
            setPhoneNumber(phoneNumber);
        }

        String street1 = (String) attributes.get("street1");

        if (street1 != null) {
            setStreet1(street1);
        }

        String street2 = (String) attributes.get("street2");

        if (street2 != null) {
            setStreet2(street2);
        }

        String zip = (String) attributes.get("zip");

        if (zip != null) {
            setZip(zip);
        }

        String city = (String) attributes.get("city");

        if (city != null) {
            setCity(city);
        }

        Long logoId = (Long) attributes.get("logoId");

        if (logoId != null) {
            setLogoId(logoId);
        }

        String logoDescription = (String) attributes.get("logoDescription");

        if (logoDescription != null) {
            setLogoDescription(logoDescription);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }
    }

    /**
    * Returns the primary key of this restaurant.
    *
    * @return the primary key of this restaurant
    */
    @Override
    public long getPrimaryKey() {
        return _restaurant.getPrimaryKey();
    }

    /**
    * Sets the primary key of this restaurant.
    *
    * @param primaryKey the primary key of this restaurant
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _restaurant.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this restaurant.
    *
    * @return the uuid of this restaurant
    */
    @Override
    public java.lang.String getUuid() {
        return _restaurant.getUuid();
    }

    /**
    * Sets the uuid of this restaurant.
    *
    * @param uuid the uuid of this restaurant
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _restaurant.setUuid(uuid);
    }

    /**
    * Returns the restaurant ID of this restaurant.
    *
    * @return the restaurant ID of this restaurant
    */
    @Override
    public long getRestaurantId() {
        return _restaurant.getRestaurantId();
    }

    /**
    * Sets the restaurant ID of this restaurant.
    *
    * @param restaurantId the restaurant ID of this restaurant
    */
    @Override
    public void setRestaurantId(long restaurantId) {
        _restaurant.setRestaurantId(restaurantId);
    }

    /**
    * Returns the group ID of this restaurant.
    *
    * @return the group ID of this restaurant
    */
    @Override
    public long getGroupId() {
        return _restaurant.getGroupId();
    }

    /**
    * Sets the group ID of this restaurant.
    *
    * @param groupId the group ID of this restaurant
    */
    @Override
    public void setGroupId(long groupId) {
        _restaurant.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this restaurant.
    *
    * @return the company ID of this restaurant
    */
    @Override
    public long getCompanyId() {
        return _restaurant.getCompanyId();
    }

    /**
    * Sets the company ID of this restaurant.
    *
    * @param companyId the company ID of this restaurant
    */
    @Override
    public void setCompanyId(long companyId) {
        _restaurant.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this restaurant.
    *
    * @return the user ID of this restaurant
    */
    @Override
    public long getUserId() {
        return _restaurant.getUserId();
    }

    /**
    * Sets the user ID of this restaurant.
    *
    * @param userId the user ID of this restaurant
    */
    @Override
    public void setUserId(long userId) {
        _restaurant.setUserId(userId);
    }

    /**
    * Returns the user uuid of this restaurant.
    *
    * @return the user uuid of this restaurant
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurant.getUserUuid();
    }

    /**
    * Sets the user uuid of this restaurant.
    *
    * @param userUuid the user uuid of this restaurant
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _restaurant.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this restaurant.
    *
    * @return the user name of this restaurant
    */
    @Override
    public java.lang.String getUserName() {
        return _restaurant.getUserName();
    }

    /**
    * Sets the user name of this restaurant.
    *
    * @param userName the user name of this restaurant
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _restaurant.setUserName(userName);
    }

    /**
    * Returns the create date of this restaurant.
    *
    * @return the create date of this restaurant
    */
    @Override
    public java.util.Date getCreateDate() {
        return _restaurant.getCreateDate();
    }

    /**
    * Sets the create date of this restaurant.
    *
    * @param createDate the create date of this restaurant
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _restaurant.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this restaurant.
    *
    * @return the modified date of this restaurant
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _restaurant.getModifiedDate();
    }

    /**
    * Sets the modified date of this restaurant.
    *
    * @param modifiedDate the modified date of this restaurant
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _restaurant.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status of this restaurant.
    *
    * @return the status of this restaurant
    */
    @Override
    public int getStatus() {
        return _restaurant.getStatus();
    }

    /**
    * Sets the status of this restaurant.
    *
    * @param status the status of this restaurant
    */
    @Override
    public void setStatus(int status) {
        _restaurant.setStatus(status);
    }

    /**
    * Returns the status by user ID of this restaurant.
    *
    * @return the status by user ID of this restaurant
    */
    @Override
    public long getStatusByUserId() {
        return _restaurant.getStatusByUserId();
    }

    /**
    * Sets the status by user ID of this restaurant.
    *
    * @param statusByUserId the status by user ID of this restaurant
    */
    @Override
    public void setStatusByUserId(long statusByUserId) {
        _restaurant.setStatusByUserId(statusByUserId);
    }

    /**
    * Returns the status by user uuid of this restaurant.
    *
    * @return the status by user uuid of this restaurant
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getStatusByUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurant.getStatusByUserUuid();
    }

    /**
    * Sets the status by user uuid of this restaurant.
    *
    * @param statusByUserUuid the status by user uuid of this restaurant
    */
    @Override
    public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
        _restaurant.setStatusByUserUuid(statusByUserUuid);
    }

    /**
    * Returns the status by user name of this restaurant.
    *
    * @return the status by user name of this restaurant
    */
    @Override
    public java.lang.String getStatusByUserName() {
        return _restaurant.getStatusByUserName();
    }

    /**
    * Sets the status by user name of this restaurant.
    *
    * @param statusByUserName the status by user name of this restaurant
    */
    @Override
    public void setStatusByUserName(java.lang.String statusByUserName) {
        _restaurant.setStatusByUserName(statusByUserName);
    }

    /**
    * Returns the status date of this restaurant.
    *
    * @return the status date of this restaurant
    */
    @Override
    public java.util.Date getStatusDate() {
        return _restaurant.getStatusDate();
    }

    /**
    * Sets the status date of this restaurant.
    *
    * @param statusDate the status date of this restaurant
    */
    @Override
    public void setStatusDate(java.util.Date statusDate) {
        _restaurant.setStatusDate(statusDate);
    }

    /**
    * Returns the email address of this restaurant.
    *
    * @return the email address of this restaurant
    */
    @Override
    public java.lang.String getEmailAddress() {
        return _restaurant.getEmailAddress();
    }

    /**
    * Sets the email address of this restaurant.
    *
    * @param emailAddress the email address of this restaurant
    */
    @Override
    public void setEmailAddress(java.lang.String emailAddress) {
        _restaurant.setEmailAddress(emailAddress);
    }

    /**
    * Returns the name of this restaurant.
    *
    * @return the name of this restaurant
    */
    @Override
    public java.lang.String getName() {
        return _restaurant.getName();
    }

    /**
    * Returns the localized name of this restaurant in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized name of this restaurant
    */
    @Override
    public java.lang.String getName(java.util.Locale locale) {
        return _restaurant.getName(locale);
    }

    /**
    * Returns the localized name of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this restaurant. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
        return _restaurant.getName(locale, useDefault);
    }

    /**
    * Returns the localized name of this restaurant in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized name of this restaurant
    */
    @Override
    public java.lang.String getName(java.lang.String languageId) {
        return _restaurant.getName(languageId);
    }

    /**
    * Returns the localized name of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized name of this restaurant
    */
    @Override
    public java.lang.String getName(java.lang.String languageId,
        boolean useDefault) {
        return _restaurant.getName(languageId, useDefault);
    }

    @Override
    public java.lang.String getNameCurrentLanguageId() {
        return _restaurant.getNameCurrentLanguageId();
    }

    @Override
    public java.lang.String getNameCurrentValue() {
        return _restaurant.getNameCurrentValue();
    }

    /**
    * Returns a map of the locales and localized names of this restaurant.
    *
    * @return the locales and localized names of this restaurant
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
        return _restaurant.getNameMap();
    }

    /**
    * Sets the name of this restaurant.
    *
    * @param name the name of this restaurant
    */
    @Override
    public void setName(java.lang.String name) {
        _restaurant.setName(name);
    }

    /**
    * Sets the localized name of this restaurant in the language.
    *
    * @param name the localized name of this restaurant
    * @param locale the locale of the language
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale) {
        _restaurant.setName(name, locale);
    }

    /**
    * Sets the localized name of this restaurant in the language, and sets the default locale.
    *
    * @param name the localized name of this restaurant
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setName(java.lang.String name, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _restaurant.setName(name, locale, defaultLocale);
    }

    @Override
    public void setNameCurrentLanguageId(java.lang.String languageId) {
        _restaurant.setNameCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized names of this restaurant from the map of locales and localized names.
    *
    * @param nameMap the locales and localized names of this restaurant
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap) {
        _restaurant.setNameMap(nameMap);
    }

    /**
    * Sets the localized names of this restaurant from the map of locales and localized names, and sets the default locale.
    *
    * @param nameMap the locales and localized names of this restaurant
    * @param defaultLocale the default locale
    */
    @Override
    public void setNameMap(
        java.util.Map<java.util.Locale, java.lang.String> nameMap,
        java.util.Locale defaultLocale) {
        _restaurant.setNameMap(nameMap, defaultLocale);
    }

    /**
    * Returns the country ID of this restaurant.
    *
    * @return the country ID of this restaurant
    */
    @Override
    public long getCountryId() {
        return _restaurant.getCountryId();
    }

    /**
    * Sets the country ID of this restaurant.
    *
    * @param countryId the country ID of this restaurant
    */
    @Override
    public void setCountryId(long countryId) {
        _restaurant.setCountryId(countryId);
    }

    /**
    * Returns the region ID of this restaurant.
    *
    * @return the region ID of this restaurant
    */
    @Override
    public long getRegionId() {
        return _restaurant.getRegionId();
    }

    /**
    * Sets the region ID of this restaurant.
    *
    * @param regionId the region ID of this restaurant
    */
    @Override
    public void setRegionId(long regionId) {
        _restaurant.setRegionId(regionId);
    }

    /**
    * Returns the phone number of this restaurant.
    *
    * @return the phone number of this restaurant
    */
    @Override
    public java.lang.String getPhoneNumber() {
        return _restaurant.getPhoneNumber();
    }

    /**
    * Sets the phone number of this restaurant.
    *
    * @param phoneNumber the phone number of this restaurant
    */
    @Override
    public void setPhoneNumber(java.lang.String phoneNumber) {
        _restaurant.setPhoneNumber(phoneNumber);
    }

    /**
    * Returns the street1 of this restaurant.
    *
    * @return the street1 of this restaurant
    */
    @Override
    public java.lang.String getStreet1() {
        return _restaurant.getStreet1();
    }

    /**
    * Sets the street1 of this restaurant.
    *
    * @param street1 the street1 of this restaurant
    */
    @Override
    public void setStreet1(java.lang.String street1) {
        _restaurant.setStreet1(street1);
    }

    /**
    * Returns the street2 of this restaurant.
    *
    * @return the street2 of this restaurant
    */
    @Override
    public java.lang.String getStreet2() {
        return _restaurant.getStreet2();
    }

    /**
    * Sets the street2 of this restaurant.
    *
    * @param street2 the street2 of this restaurant
    */
    @Override
    public void setStreet2(java.lang.String street2) {
        _restaurant.setStreet2(street2);
    }

    /**
    * Returns the zip of this restaurant.
    *
    * @return the zip of this restaurant
    */
    @Override
    public java.lang.String getZip() {
        return _restaurant.getZip();
    }

    /**
    * Sets the zip of this restaurant.
    *
    * @param zip the zip of this restaurant
    */
    @Override
    public void setZip(java.lang.String zip) {
        _restaurant.setZip(zip);
    }

    /**
    * Returns the city of this restaurant.
    *
    * @return the city of this restaurant
    */
    @Override
    public java.lang.String getCity() {
        return _restaurant.getCity();
    }

    /**
    * Sets the city of this restaurant.
    *
    * @param city the city of this restaurant
    */
    @Override
    public void setCity(java.lang.String city) {
        _restaurant.setCity(city);
    }

    /**
    * Returns the logo ID of this restaurant.
    *
    * @return the logo ID of this restaurant
    */
    @Override
    public long getLogoId() {
        return _restaurant.getLogoId();
    }

    /**
    * Sets the logo ID of this restaurant.
    *
    * @param logoId the logo ID of this restaurant
    */
    @Override
    public void setLogoId(long logoId) {
        _restaurant.setLogoId(logoId);
    }

    /**
    * Returns the logo description of this restaurant.
    *
    * @return the logo description of this restaurant
    */
    @Override
    public java.lang.String getLogoDescription() {
        return _restaurant.getLogoDescription();
    }

    /**
    * Returns the localized logo description of this restaurant in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized logo description of this restaurant
    */
    @Override
    public java.lang.String getLogoDescription(java.util.Locale locale) {
        return _restaurant.getLogoDescription(locale);
    }

    /**
    * Returns the localized logo description of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized logo description of this restaurant. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getLogoDescription(java.util.Locale locale,
        boolean useDefault) {
        return _restaurant.getLogoDescription(locale, useDefault);
    }

    /**
    * Returns the localized logo description of this restaurant in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized logo description of this restaurant
    */
    @Override
    public java.lang.String getLogoDescription(java.lang.String languageId) {
        return _restaurant.getLogoDescription(languageId);
    }

    /**
    * Returns the localized logo description of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized logo description of this restaurant
    */
    @Override
    public java.lang.String getLogoDescription(java.lang.String languageId,
        boolean useDefault) {
        return _restaurant.getLogoDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getLogoDescriptionCurrentLanguageId() {
        return _restaurant.getLogoDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getLogoDescriptionCurrentValue() {
        return _restaurant.getLogoDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized logo descriptions of this restaurant.
    *
    * @return the locales and localized logo descriptions of this restaurant
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getLogoDescriptionMap() {
        return _restaurant.getLogoDescriptionMap();
    }

    /**
    * Sets the logo description of this restaurant.
    *
    * @param logoDescription the logo description of this restaurant
    */
    @Override
    public void setLogoDescription(java.lang.String logoDescription) {
        _restaurant.setLogoDescription(logoDescription);
    }

    /**
    * Sets the localized logo description of this restaurant in the language.
    *
    * @param logoDescription the localized logo description of this restaurant
    * @param locale the locale of the language
    */
    @Override
    public void setLogoDescription(java.lang.String logoDescription,
        java.util.Locale locale) {
        _restaurant.setLogoDescription(logoDescription, locale);
    }

    /**
    * Sets the localized logo description of this restaurant in the language, and sets the default locale.
    *
    * @param logoDescription the localized logo description of this restaurant
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setLogoDescription(java.lang.String logoDescription,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _restaurant.setLogoDescription(logoDescription, locale, defaultLocale);
    }

    @Override
    public void setLogoDescriptionCurrentLanguageId(java.lang.String languageId) {
        _restaurant.setLogoDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized logo descriptions of this restaurant from the map of locales and localized logo descriptions.
    *
    * @param logoDescriptionMap the locales and localized logo descriptions of this restaurant
    */
    @Override
    public void setLogoDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> logoDescriptionMap) {
        _restaurant.setLogoDescriptionMap(logoDescriptionMap);
    }

    /**
    * Sets the localized logo descriptions of this restaurant from the map of locales and localized logo descriptions, and sets the default locale.
    *
    * @param logoDescriptionMap the locales and localized logo descriptions of this restaurant
    * @param defaultLocale the default locale
    */
    @Override
    public void setLogoDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> logoDescriptionMap,
        java.util.Locale defaultLocale) {
        _restaurant.setLogoDescriptionMap(logoDescriptionMap, defaultLocale);
    }

    /**
    * Returns the description of this restaurant.
    *
    * @return the description of this restaurant
    */
    @Override
    public java.lang.String getDescription() {
        return _restaurant.getDescription();
    }

    /**
    * Returns the localized description of this restaurant in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized description of this restaurant
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale) {
        return _restaurant.getDescription(locale);
    }

    /**
    * Returns the localized description of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this restaurant. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getDescription(java.util.Locale locale,
        boolean useDefault) {
        return _restaurant.getDescription(locale, useDefault);
    }

    /**
    * Returns the localized description of this restaurant in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized description of this restaurant
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId) {
        return _restaurant.getDescription(languageId);
    }

    /**
    * Returns the localized description of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized description of this restaurant
    */
    @Override
    public java.lang.String getDescription(java.lang.String languageId,
        boolean useDefault) {
        return _restaurant.getDescription(languageId, useDefault);
    }

    @Override
    public java.lang.String getDescriptionCurrentLanguageId() {
        return _restaurant.getDescriptionCurrentLanguageId();
    }

    @Override
    public java.lang.String getDescriptionCurrentValue() {
        return _restaurant.getDescriptionCurrentValue();
    }

    /**
    * Returns a map of the locales and localized descriptions of this restaurant.
    *
    * @return the locales and localized descriptions of this restaurant
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
        return _restaurant.getDescriptionMap();
    }

    /**
    * Sets the description of this restaurant.
    *
    * @param description the description of this restaurant
    */
    @Override
    public void setDescription(java.lang.String description) {
        _restaurant.setDescription(description);
    }

    /**
    * Sets the localized description of this restaurant in the language.
    *
    * @param description the localized description of this restaurant
    * @param locale the locale of the language
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale) {
        _restaurant.setDescription(description, locale);
    }

    /**
    * Sets the localized description of this restaurant in the language, and sets the default locale.
    *
    * @param description the localized description of this restaurant
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescription(java.lang.String description,
        java.util.Locale locale, java.util.Locale defaultLocale) {
        _restaurant.setDescription(description, locale, defaultLocale);
    }

    @Override
    public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
        _restaurant.setDescriptionCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized descriptions of this restaurant from the map of locales and localized descriptions.
    *
    * @param descriptionMap the locales and localized descriptions of this restaurant
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
        _restaurant.setDescriptionMap(descriptionMap);
    }

    /**
    * Sets the localized descriptions of this restaurant from the map of locales and localized descriptions, and sets the default locale.
    *
    * @param descriptionMap the locales and localized descriptions of this restaurant
    * @param defaultLocale the default locale
    */
    @Override
    public void setDescriptionMap(
        java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
        java.util.Locale defaultLocale) {
        _restaurant.setDescriptionMap(descriptionMap, defaultLocale);
    }

    /**
    * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
    */
    @Override
    public boolean getApproved() {
        return _restaurant.getApproved();
    }

    /**
    * Returns <code>true</code> if this restaurant is approved.
    *
    * @return <code>true</code> if this restaurant is approved; <code>false</code> otherwise
    */
    @Override
    public boolean isApproved() {
        return _restaurant.isApproved();
    }

    /**
    * Returns <code>true</code> if this restaurant is denied.
    *
    * @return <code>true</code> if this restaurant is denied; <code>false</code> otherwise
    */
    @Override
    public boolean isDenied() {
        return _restaurant.isDenied();
    }

    /**
    * Returns <code>true</code> if this restaurant is a draft.
    *
    * @return <code>true</code> if this restaurant is a draft; <code>false</code> otherwise
    */
    @Override
    public boolean isDraft() {
        return _restaurant.isDraft();
    }

    /**
    * Returns <code>true</code> if this restaurant is expired.
    *
    * @return <code>true</code> if this restaurant is expired; <code>false</code> otherwise
    */
    @Override
    public boolean isExpired() {
        return _restaurant.isExpired();
    }

    /**
    * Returns <code>true</code> if this restaurant is inactive.
    *
    * @return <code>true</code> if this restaurant is inactive; <code>false</code> otherwise
    */
    @Override
    public boolean isInactive() {
        return _restaurant.isInactive();
    }

    /**
    * Returns <code>true</code> if this restaurant is incomplete.
    *
    * @return <code>true</code> if this restaurant is incomplete; <code>false</code> otherwise
    */
    @Override
    public boolean isIncomplete() {
        return _restaurant.isIncomplete();
    }

    /**
    * Returns <code>true</code> if this restaurant is pending.
    *
    * @return <code>true</code> if this restaurant is pending; <code>false</code> otherwise
    */
    @Override
    public boolean isPending() {
        return _restaurant.isPending();
    }

    /**
    * Returns <code>true</code> if this restaurant is scheduled.
    *
    * @return <code>true</code> if this restaurant is scheduled; <code>false</code> otherwise
    */
    @Override
    public boolean isScheduled() {
        return _restaurant.isScheduled();
    }

    @Override
    public boolean isNew() {
        return _restaurant.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _restaurant.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _restaurant.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _restaurant.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _restaurant.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _restaurant.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _restaurant.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _restaurant.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _restaurant.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _restaurant.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _restaurant.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _restaurant.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _restaurant.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _restaurant.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _restaurant.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new RestaurantWrapper((Restaurant) _restaurant.clone());
    }

    @Override
    public int compareTo(Restaurant restaurant) {
        return _restaurant.compareTo(restaurant);
    }

    @Override
    public int hashCode() {
        return _restaurant.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Restaurant> toCacheModel() {
        return _restaurant.toCacheModel();
    }

    @Override
    public Restaurant toEscapedModel() {
        return new RestaurantWrapper(_restaurant.toEscapedModel());
    }

    @Override
    public Restaurant toUnescapedModel() {
        return new RestaurantWrapper(_restaurant.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _restaurant.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _restaurant.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _restaurant.persist();
    }

    @Override
    public java.io.InputStream getLogoInputStream() {
        return _restaurant.getLogoInputStream();
    }

    @Override
    public void setLogoInputStream(java.io.InputStream logoInputStream) {
        _restaurant.setLogoInputStream(logoInputStream);
    }

    @Override
    public java.lang.String getStatus(java.util.Locale locale) {
        return _restaurant.getStatus(locale);
    }

    @Override
    public java.lang.String getRegion() {
        return _restaurant.getRegion();
    }

    @Override
    public java.lang.String getCountry(java.util.Locale locale) {
        return _restaurant.getCountry(locale);
    }

    @Override
    public java.lang.String getLogoSrc(
        com.liferay.portal.theme.ThemeDisplay themeDisplay) {
        return _restaurant.getLogoSrc(themeDisplay);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RestaurantWrapper)) {
            return false;
        }

        RestaurantWrapper restaurantWrapper = (RestaurantWrapper) obj;

        if (Validator.equals(_restaurant, restaurantWrapper._restaurant)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _restaurant.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Restaurant getWrappedRestaurant() {
        return _restaurant;
    }

    @Override
    public Restaurant getWrappedModel() {
        return _restaurant;
    }

    @Override
    public void resetOriginalValues() {
        _restaurant.resetOriginalValues();
    }
}
