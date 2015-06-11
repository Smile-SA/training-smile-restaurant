package com.smile.plugins.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Restaurant service. Represents a row in the &quot;MealTime_Restaurant&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.smile.plugins.model.impl.RestaurantModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.smile.plugins.model.impl.RestaurantImpl}.
 * </p>
 *
 * @author guillaume Lenoir
 * @see Restaurant
 * @see com.smile.plugins.model.impl.RestaurantImpl
 * @see com.smile.plugins.model.impl.RestaurantModelImpl
 * @generated
 */
public interface RestaurantModel extends BaseModel<Restaurant>,
    StagedGroupedModel, WorkflowedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a restaurant model instance should use the {@link Restaurant} interface instead.
     */

    /**
     * Returns the primary key of this restaurant.
     *
     * @return the primary key of this restaurant
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this restaurant.
     *
     * @param primaryKey the primary key of this restaurant
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this restaurant.
     *
     * @return the uuid of this restaurant
     */
    @AutoEscape
    @Override
    public String getUuid();

    /**
     * Sets the uuid of this restaurant.
     *
     * @param uuid the uuid of this restaurant
     */
    @Override
    public void setUuid(String uuid);

    /**
     * Returns the restaurant ID of this restaurant.
     *
     * @return the restaurant ID of this restaurant
     */
    public long getRestaurantId();

    /**
     * Sets the restaurant ID of this restaurant.
     *
     * @param restaurantId the restaurant ID of this restaurant
     */
    public void setRestaurantId(long restaurantId);

    /**
     * Returns the group ID of this restaurant.
     *
     * @return the group ID of this restaurant
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this restaurant.
     *
     * @param groupId the group ID of this restaurant
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this restaurant.
     *
     * @return the company ID of this restaurant
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this restaurant.
     *
     * @param companyId the company ID of this restaurant
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this restaurant.
     *
     * @return the user ID of this restaurant
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this restaurant.
     *
     * @param userId the user ID of this restaurant
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this restaurant.
     *
     * @return the user uuid of this restaurant
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this restaurant.
     *
     * @param userUuid the user uuid of this restaurant
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this restaurant.
     *
     * @return the user name of this restaurant
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this restaurant.
     *
     * @param userName the user name of this restaurant
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this restaurant.
     *
     * @return the create date of this restaurant
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this restaurant.
     *
     * @param createDate the create date of this restaurant
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this restaurant.
     *
     * @return the modified date of this restaurant
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this restaurant.
     *
     * @param modifiedDate the modified date of this restaurant
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the status of this restaurant.
     *
     * @return the status of this restaurant
     */
    @Override
    public int getStatus();

    /**
     * Sets the status of this restaurant.
     *
     * @param status the status of this restaurant
     */
    @Override
    public void setStatus(int status);

    /**
     * Returns the status by user ID of this restaurant.
     *
     * @return the status by user ID of this restaurant
     */
    @Override
    public long getStatusByUserId();

    /**
     * Sets the status by user ID of this restaurant.
     *
     * @param statusByUserId the status by user ID of this restaurant
     */
    @Override
    public void setStatusByUserId(long statusByUserId);

    /**
     * Returns the status by user uuid of this restaurant.
     *
     * @return the status by user uuid of this restaurant
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getStatusByUserUuid() throws SystemException;

    /**
     * Sets the status by user uuid of this restaurant.
     *
     * @param statusByUserUuid the status by user uuid of this restaurant
     */
    @Override
    public void setStatusByUserUuid(String statusByUserUuid);

    /**
     * Returns the status by user name of this restaurant.
     *
     * @return the status by user name of this restaurant
     */
    @AutoEscape
    @Override
    public String getStatusByUserName();

    /**
     * Sets the status by user name of this restaurant.
     *
     * @param statusByUserName the status by user name of this restaurant
     */
    @Override
    public void setStatusByUserName(String statusByUserName);

    /**
     * Returns the status date of this restaurant.
     *
     * @return the status date of this restaurant
     */
    @Override
    public Date getStatusDate();

    /**
     * Sets the status date of this restaurant.
     *
     * @param statusDate the status date of this restaurant
     */
    @Override
    public void setStatusDate(Date statusDate);

    /**
     * Returns the email address of this restaurant.
     *
     * @return the email address of this restaurant
     */
    @AutoEscape
    public String getEmailAddress();

    /**
     * Sets the email address of this restaurant.
     *
     * @param emailAddress the email address of this restaurant
     */
    public void setEmailAddress(String emailAddress);

    /**
     * Returns the name of this restaurant.
     *
     * @return the name of this restaurant
     */
    public String getName();

    /**
     * Returns the localized name of this restaurant in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param locale the locale of the language
     * @return the localized name of this restaurant
     */
    @AutoEscape
    public String getName(Locale locale);

    /**
     * Returns the localized name of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param locale the local of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized name of this restaurant. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
     */
    @AutoEscape
    public String getName(Locale locale, boolean useDefault);

    /**
     * Returns the localized name of this restaurant in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @return the localized name of this restaurant
     */
    @AutoEscape
    public String getName(String languageId);

    /**
     * Returns the localized name of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized name of this restaurant
     */
    @AutoEscape
    public String getName(String languageId, boolean useDefault);

    @AutoEscape
    public String getNameCurrentLanguageId();

    @AutoEscape
    public String getNameCurrentValue();

    /**
     * Returns a map of the locales and localized names of this restaurant.
     *
     * @return the locales and localized names of this restaurant
     */
    public Map<Locale, String> getNameMap();

    /**
     * Sets the name of this restaurant.
     *
     * @param name the name of this restaurant
     */
    public void setName(String name);

    /**
     * Sets the localized name of this restaurant in the language.
     *
     * @param name the localized name of this restaurant
     * @param locale the locale of the language
     */
    public void setName(String name, Locale locale);

    /**
     * Sets the localized name of this restaurant in the language, and sets the default locale.
     *
     * @param name the localized name of this restaurant
     * @param locale the locale of the language
     * @param defaultLocale the default locale
     */
    public void setName(String name, Locale locale, Locale defaultLocale);

    public void setNameCurrentLanguageId(String languageId);

    /**
     * Sets the localized names of this restaurant from the map of locales and localized names.
     *
     * @param nameMap the locales and localized names of this restaurant
     */
    public void setNameMap(Map<Locale, String> nameMap);

    /**
     * Sets the localized names of this restaurant from the map of locales and localized names, and sets the default locale.
     *
     * @param nameMap the locales and localized names of this restaurant
     * @param defaultLocale the default locale
     */
    public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

    /**
     * Returns the country ID of this restaurant.
     *
     * @return the country ID of this restaurant
     */
    public long getCountryId();

    /**
     * Sets the country ID of this restaurant.
     *
     * @param countryId the country ID of this restaurant
     */
    public void setCountryId(long countryId);

    /**
     * Returns the region ID of this restaurant.
     *
     * @return the region ID of this restaurant
     */
    public long getRegionId();

    /**
     * Sets the region ID of this restaurant.
     *
     * @param regionId the region ID of this restaurant
     */
    public void setRegionId(long regionId);

    /**
     * Returns the phone number of this restaurant.
     *
     * @return the phone number of this restaurant
     */
    @AutoEscape
    public String getPhoneNumber();

    /**
     * Sets the phone number of this restaurant.
     *
     * @param phoneNumber the phone number of this restaurant
     */
    public void setPhoneNumber(String phoneNumber);

    /**
     * Returns the street1 of this restaurant.
     *
     * @return the street1 of this restaurant
     */
    @AutoEscape
    public String getStreet1();

    /**
     * Sets the street1 of this restaurant.
     *
     * @param street1 the street1 of this restaurant
     */
    public void setStreet1(String street1);

    /**
     * Returns the street2 of this restaurant.
     *
     * @return the street2 of this restaurant
     */
    @AutoEscape
    public String getStreet2();

    /**
     * Sets the street2 of this restaurant.
     *
     * @param street2 the street2 of this restaurant
     */
    public void setStreet2(String street2);

    /**
     * Returns the zip of this restaurant.
     *
     * @return the zip of this restaurant
     */
    @AutoEscape
    public String getZip();

    /**
     * Sets the zip of this restaurant.
     *
     * @param zip the zip of this restaurant
     */
    public void setZip(String zip);

    /**
     * Returns the city of this restaurant.
     *
     * @return the city of this restaurant
     */
    @AutoEscape
    public String getCity();

    /**
     * Sets the city of this restaurant.
     *
     * @param city the city of this restaurant
     */
    public void setCity(String city);

    /**
     * Returns the logo ID of this restaurant.
     *
     * @return the logo ID of this restaurant
     */
    public long getLogoId();

    /**
     * Sets the logo ID of this restaurant.
     *
     * @param logoId the logo ID of this restaurant
     */
    public void setLogoId(long logoId);

    /**
     * Returns the logo description of this restaurant.
     *
     * @return the logo description of this restaurant
     */
    public String getLogoDescription();

    /**
     * Returns the localized logo description of this restaurant in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param locale the locale of the language
     * @return the localized logo description of this restaurant
     */
    @AutoEscape
    public String getLogoDescription(Locale locale);

    /**
     * Returns the localized logo description of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param locale the local of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized logo description of this restaurant. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
     */
    @AutoEscape
    public String getLogoDescription(Locale locale, boolean useDefault);

    /**
     * Returns the localized logo description of this restaurant in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @return the localized logo description of this restaurant
     */
    @AutoEscape
    public String getLogoDescription(String languageId);

    /**
     * Returns the localized logo description of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized logo description of this restaurant
     */
    @AutoEscape
    public String getLogoDescription(String languageId, boolean useDefault);

    @AutoEscape
    public String getLogoDescriptionCurrentLanguageId();

    @AutoEscape
    public String getLogoDescriptionCurrentValue();

    /**
     * Returns a map of the locales and localized logo descriptions of this restaurant.
     *
     * @return the locales and localized logo descriptions of this restaurant
     */
    public Map<Locale, String> getLogoDescriptionMap();

    /**
     * Sets the logo description of this restaurant.
     *
     * @param logoDescription the logo description of this restaurant
     */
    public void setLogoDescription(String logoDescription);

    /**
     * Sets the localized logo description of this restaurant in the language.
     *
     * @param logoDescription the localized logo description of this restaurant
     * @param locale the locale of the language
     */
    public void setLogoDescription(String logoDescription, Locale locale);

    /**
     * Sets the localized logo description of this restaurant in the language, and sets the default locale.
     *
     * @param logoDescription the localized logo description of this restaurant
     * @param locale the locale of the language
     * @param defaultLocale the default locale
     */
    public void setLogoDescription(String logoDescription, Locale locale,
        Locale defaultLocale);

    public void setLogoDescriptionCurrentLanguageId(String languageId);

    /**
     * Sets the localized logo descriptions of this restaurant from the map of locales and localized logo descriptions.
     *
     * @param logoDescriptionMap the locales and localized logo descriptions of this restaurant
     */
    public void setLogoDescriptionMap(Map<Locale, String> logoDescriptionMap);

    /**
     * Sets the localized logo descriptions of this restaurant from the map of locales and localized logo descriptions, and sets the default locale.
     *
     * @param logoDescriptionMap the locales and localized logo descriptions of this restaurant
     * @param defaultLocale the default locale
     */
    public void setLogoDescriptionMap(Map<Locale, String> logoDescriptionMap,
        Locale defaultLocale);

    /**
     * Returns the description of this restaurant.
     *
     * @return the description of this restaurant
     */
    public String getDescription();

    /**
     * Returns the localized description of this restaurant in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param locale the locale of the language
     * @return the localized description of this restaurant
     */
    @AutoEscape
    public String getDescription(Locale locale);

    /**
     * Returns the localized description of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param locale the local of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized description of this restaurant. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
     */
    @AutoEscape
    public String getDescription(Locale locale, boolean useDefault);

    /**
     * Returns the localized description of this restaurant in the language. Uses the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @return the localized description of this restaurant
     */
    @AutoEscape
    public String getDescription(String languageId);

    /**
     * Returns the localized description of this restaurant in the language, optionally using the default language if no localization exists for the requested language.
     *
     * @param languageId the ID of the language
     * @param useDefault whether to use the default language if no localization exists for the requested language
     * @return the localized description of this restaurant
     */
    @AutoEscape
    public String getDescription(String languageId, boolean useDefault);

    @AutoEscape
    public String getDescriptionCurrentLanguageId();

    @AutoEscape
    public String getDescriptionCurrentValue();

    /**
     * Returns a map of the locales and localized descriptions of this restaurant.
     *
     * @return the locales and localized descriptions of this restaurant
     */
    public Map<Locale, String> getDescriptionMap();

    /**
     * Sets the description of this restaurant.
     *
     * @param description the description of this restaurant
     */
    public void setDescription(String description);

    /**
     * Sets the localized description of this restaurant in the language.
     *
     * @param description the localized description of this restaurant
     * @param locale the locale of the language
     */
    public void setDescription(String description, Locale locale);

    /**
     * Sets the localized description of this restaurant in the language, and sets the default locale.
     *
     * @param description the localized description of this restaurant
     * @param locale the locale of the language
     * @param defaultLocale the default locale
     */
    public void setDescription(String description, Locale locale,
        Locale defaultLocale);

    public void setDescriptionCurrentLanguageId(String languageId);

    /**
     * Sets the localized descriptions of this restaurant from the map of locales and localized descriptions.
     *
     * @param descriptionMap the locales and localized descriptions of this restaurant
     */
    public void setDescriptionMap(Map<Locale, String> descriptionMap);

    /**
     * Sets the localized descriptions of this restaurant from the map of locales and localized descriptions, and sets the default locale.
     *
     * @param descriptionMap the locales and localized descriptions of this restaurant
     * @param defaultLocale the default locale
     */
    public void setDescriptionMap(Map<Locale, String> descriptionMap,
        Locale defaultLocale);

    /**
     * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
     */
    @Override
    public boolean getApproved();

    /**
     * Returns <code>true</code> if this restaurant is approved.
     *
     * @return <code>true</code> if this restaurant is approved; <code>false</code> otherwise
     */
    @Override
    public boolean isApproved();

    /**
     * Returns <code>true</code> if this restaurant is denied.
     *
     * @return <code>true</code> if this restaurant is denied; <code>false</code> otherwise
     */
    @Override
    public boolean isDenied();

    /**
     * Returns <code>true</code> if this restaurant is a draft.
     *
     * @return <code>true</code> if this restaurant is a draft; <code>false</code> otherwise
     */
    @Override
    public boolean isDraft();

    /**
     * Returns <code>true</code> if this restaurant is expired.
     *
     * @return <code>true</code> if this restaurant is expired; <code>false</code> otherwise
     */
    @Override
    public boolean isExpired();

    /**
     * Returns <code>true</code> if this restaurant is inactive.
     *
     * @return <code>true</code> if this restaurant is inactive; <code>false</code> otherwise
     */
    @Override
    public boolean isInactive();

    /**
     * Returns <code>true</code> if this restaurant is incomplete.
     *
     * @return <code>true</code> if this restaurant is incomplete; <code>false</code> otherwise
     */
    @Override
    public boolean isIncomplete();

    /**
     * Returns <code>true</code> if this restaurant is pending.
     *
     * @return <code>true</code> if this restaurant is pending; <code>false</code> otherwise
     */
    @Override
    public boolean isPending();

    /**
     * Returns <code>true</code> if this restaurant is scheduled.
     *
     * @return <code>true</code> if this restaurant is scheduled; <code>false</code> otherwise
     */
    @Override
    public boolean isScheduled();

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public String[] getAvailableLanguageIds();

    public String getDefaultLanguageId();

    public void prepareLocalizedFieldsForImport() throws LocaleException;

    public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
        throws LocaleException;

    @Override
    public Object clone();

    @Override
    public int compareTo(Restaurant restaurant);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Restaurant> toCacheModel();

    @Override
    public Restaurant toEscapedModel();

    @Override
    public Restaurant toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
