package com.smile.plugins.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.smile.plugins.service.ClpSerializer;
import com.smile.plugins.service.RestaurantLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class RestaurantClp extends BaseModelImpl<Restaurant>
    implements Restaurant {
    private String _uuid;
    private long _restaurantId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;
    private long _statusByUserId;
    private String _statusByUserUuid;
    private String _statusByUserName;
    private Date _statusDate;
    private String _emailAddress;
    private String _name;
    private String _nameCurrentLanguageId;
    private long _countryId;
    private long _regionId;
    private String _phoneNumber;
    private String _street1;
    private String _street2;
    private String _zip;
    private String _city;
    private long _logoId;
    private String _logoDescription;
    private String _logoDescriptionCurrentLanguageId;
    private String _description;
    private String _descriptionCurrentLanguageId;
    private BaseModel<?> _restaurantRemoteModel;
    private Class<?> _clpSerializerClass = com.smile.plugins.service.ClpSerializer.class;

    public RestaurantClp() {
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
    public long getPrimaryKey() {
        return _restaurantId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRestaurantId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _restaurantId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_restaurantRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRestaurantId() {
        return _restaurantId;
    }

    @Override
    public void setRestaurantId(long restaurantId) {
        _restaurantId = restaurantId;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setRestaurantId", long.class);

                method.invoke(_restaurantRemoteModel, restaurantId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_restaurantRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_restaurantRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_restaurantRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_restaurantRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_restaurantRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_restaurantRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_restaurantRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getStatusByUserId() {
        return _statusByUserId;
    }

    @Override
    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusByUserId", long.class);

                method.invoke(_restaurantRemoteModel, statusByUserId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatusByUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
            _statusByUserUuid);
    }

    @Override
    public void setStatusByUserUuid(String statusByUserUuid) {
        _statusByUserUuid = statusByUserUuid;
    }

    @Override
    public String getStatusByUserName() {
        return _statusByUserName;
    }

    @Override
    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusByUserName",
                        String.class);

                method.invoke(_restaurantRemoteModel, statusByUserName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getStatusDate() {
        return _statusDate;
    }

    @Override
    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setStatusDate", Date.class);

                method.invoke(_restaurantRemoteModel, statusDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailAddress() {
        return _emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailAddress", String.class);

                method.invoke(_restaurantRemoteModel, emailAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public String getName(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getName(languageId);
    }

    @Override
    public String getName(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getName(languageId, useDefault);
    }

    @Override
    public String getName(String languageId) {
        return LocalizationUtil.getLocalization(getName(), languageId);
    }

    @Override
    public String getName(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getName(), languageId,
            useDefault);
    }

    @Override
    public String getNameCurrentLanguageId() {
        return _nameCurrentLanguageId;
    }

    @Override
    public String getNameCurrentValue() {
        Locale locale = getLocale(_nameCurrentLanguageId);

        return getName(locale);
    }

    @Override
    public Map<Locale, String> getNameMap() {
        return LocalizationUtil.getLocalizationMap(getName());
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_restaurantRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setName(String name, Locale locale) {
        setName(name, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setName(String name, Locale locale, Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(name)) {
            setName(LocalizationUtil.updateLocalization(getName(), "Name",
                    name, languageId, defaultLanguageId));
        } else {
            setName(LocalizationUtil.removeLocalization(getName(), "Name",
                    languageId));
        }
    }

    @Override
    public void setNameCurrentLanguageId(String languageId) {
        _nameCurrentLanguageId = languageId;
    }

    @Override
    public void setNameMap(Map<Locale, String> nameMap) {
        setNameMap(nameMap, LocaleUtil.getDefault());
    }

    @Override
    public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
        if (nameMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setName(LocalizationUtil.updateLocalization(nameMap, getName(),
                    "Name", LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public long getCountryId() {
        return _countryId;
    }

    @Override
    public void setCountryId(long countryId) {
        _countryId = countryId;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setCountryId", long.class);

                method.invoke(_restaurantRemoteModel, countryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRegionId() {
        return _regionId;
    }

    @Override
    public void setRegionId(long regionId) {
        _regionId = regionId;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setRegionId", long.class);

                method.invoke(_restaurantRemoteModel, regionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPhoneNumber() {
        return _phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber = phoneNumber;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setPhoneNumber", String.class);

                method.invoke(_restaurantRemoteModel, phoneNumber);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStreet1() {
        return _street1;
    }

    @Override
    public void setStreet1(String street1) {
        _street1 = street1;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setStreet1", String.class);

                method.invoke(_restaurantRemoteModel, street1);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStreet2() {
        return _street2;
    }

    @Override
    public void setStreet2(String street2) {
        _street2 = street2;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setStreet2", String.class);

                method.invoke(_restaurantRemoteModel, street2);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getZip() {
        return _zip;
    }

    @Override
    public void setZip(String zip) {
        _zip = zip;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setZip", String.class);

                method.invoke(_restaurantRemoteModel, zip);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCity() {
        return _city;
    }

    @Override
    public void setCity(String city) {
        _city = city;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setCity", String.class);

                method.invoke(_restaurantRemoteModel, city);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getLogoId() {
        return _logoId;
    }

    @Override
    public void setLogoId(long logoId) {
        _logoId = logoId;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setLogoId", long.class);

                method.invoke(_restaurantRemoteModel, logoId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLogoDescription() {
        return _logoDescription;
    }

    @Override
    public String getLogoDescription(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getLogoDescription(languageId);
    }

    @Override
    public String getLogoDescription(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getLogoDescription(languageId, useDefault);
    }

    @Override
    public String getLogoDescription(String languageId) {
        return LocalizationUtil.getLocalization(getLogoDescription(), languageId);
    }

    @Override
    public String getLogoDescription(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getLogoDescription(),
            languageId, useDefault);
    }

    @Override
    public String getLogoDescriptionCurrentLanguageId() {
        return _logoDescriptionCurrentLanguageId;
    }

    @Override
    public String getLogoDescriptionCurrentValue() {
        Locale locale = getLocale(_logoDescriptionCurrentLanguageId);

        return getLogoDescription(locale);
    }

    @Override
    public Map<Locale, String> getLogoDescriptionMap() {
        return LocalizationUtil.getLocalizationMap(getLogoDescription());
    }

    @Override
    public void setLogoDescription(String logoDescription) {
        _logoDescription = logoDescription;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setLogoDescription",
                        String.class);

                method.invoke(_restaurantRemoteModel, logoDescription);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setLogoDescription(String logoDescription, Locale locale) {
        setLogoDescription(logoDescription, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setLogoDescription(String logoDescription, Locale locale,
        Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(logoDescription)) {
            setLogoDescription(LocalizationUtil.updateLocalization(
                    getLogoDescription(), "LogoDescription", logoDescription,
                    languageId, defaultLanguageId));
        } else {
            setLogoDescription(LocalizationUtil.removeLocalization(
                    getLogoDescription(), "LogoDescription", languageId));
        }
    }

    @Override
    public void setLogoDescriptionCurrentLanguageId(String languageId) {
        _logoDescriptionCurrentLanguageId = languageId;
    }

    @Override
    public void setLogoDescriptionMap(Map<Locale, String> logoDescriptionMap) {
        setLogoDescriptionMap(logoDescriptionMap, LocaleUtil.getDefault());
    }

    @Override
    public void setLogoDescriptionMap(Map<Locale, String> logoDescriptionMap,
        Locale defaultLocale) {
        if (logoDescriptionMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setLogoDescription(LocalizationUtil.updateLocalization(
                    logoDescriptionMap, getLogoDescription(),
                    "LogoDescription", LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public String getDescription(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getDescription(languageId);
    }

    @Override
    public String getDescription(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getDescription(languageId, useDefault);
    }

    @Override
    public String getDescription(String languageId) {
        return LocalizationUtil.getLocalization(getDescription(), languageId);
    }

    @Override
    public String getDescription(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getDescription(), languageId,
            useDefault);
    }

    @Override
    public String getDescriptionCurrentLanguageId() {
        return _descriptionCurrentLanguageId;
    }

    @Override
    public String getDescriptionCurrentValue() {
        Locale locale = getLocale(_descriptionCurrentLanguageId);

        return getDescription(locale);
    }

    @Override
    public Map<Locale, String> getDescriptionMap() {
        return LocalizationUtil.getLocalizationMap(getDescription());
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_restaurantRemoteModel != null) {
            try {
                Class<?> clazz = _restaurantRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_restaurantRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setDescription(String description, Locale locale) {
        setDescription(description, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setDescription(String description, Locale locale,
        Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(description)) {
            setDescription(LocalizationUtil.updateLocalization(
                    getDescription(), "Description", description, languageId,
                    defaultLanguageId));
        } else {
            setDescription(LocalizationUtil.removeLocalization(
                    getDescription(), "Description", languageId));
        }
    }

    @Override
    public void setDescriptionCurrentLanguageId(String languageId) {
        _descriptionCurrentLanguageId = languageId;
    }

    @Override
    public void setDescriptionMap(Map<Locale, String> descriptionMap) {
        setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
    }

    @Override
    public void setDescriptionMap(Map<Locale, String> descriptionMap,
        Locale defaultLocale) {
        if (descriptionMap == null) {
            return;
        }

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setDescription(LocalizationUtil.updateLocalization(descriptionMap,
                    getDescription(), "Description",
                    LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public java.lang.String getCountry(java.util.Locale locale) {
        try {
            String methodName = "getCountry";

            Class<?>[] parameterTypes = new Class<?>[] { java.util.Locale.class };

            Object[] parameterValues = new Object[] { locale };

            java.lang.String returnObj = (java.lang.String) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public void setLogoInputStream(java.io.InputStream logoInputStream) {
        try {
            String methodName = "setLogoInputStream";

            Class<?>[] parameterTypes = new Class<?>[] { java.io.InputStream.class };

            Object[] parameterValues = new Object[] { logoInputStream };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public java.lang.String getLogoSrc(
        com.liferay.portal.theme.ThemeDisplay themeDisplay) {
        try {
            String methodName = "getLogoSrc";

            Class<?>[] parameterTypes = new Class<?>[] {
                    com.liferay.portal.theme.ThemeDisplay.class
                };

            Object[] parameterValues = new Object[] { themeDisplay };

            java.lang.String returnObj = (java.lang.String) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public java.io.InputStream getLogoInputStream() {
        try {
            String methodName = "getLogoInputStream";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.io.InputStream returnObj = (java.io.InputStream) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public java.lang.String getRegion() {
        try {
            String methodName = "getRegion";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.lang.String returnObj = (java.lang.String) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public java.lang.String getStatus(java.util.Locale locale) {
        try {
            String methodName = "getStatus";

            Class<?>[] parameterTypes = new Class<?>[] { java.util.Locale.class };

            Object[] parameterValues = new Object[] { locale };

            java.lang.String returnObj = (java.lang.String) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Restaurant.class.getName()));
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #isApproved}
     */
    @Override
    public boolean getApproved() {
        return isApproved();
    }

    @Override
    public boolean isApproved() {
        if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDenied() {
        if (getStatus() == WorkflowConstants.STATUS_DENIED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDraft() {
        if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isExpired() {
        if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isInactive() {
        if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isIncomplete() {
        if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isPending() {
        if (getStatus() == WorkflowConstants.STATUS_PENDING) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isScheduled() {
        if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
            return true;
        } else {
            return false;
        }
    }

    public BaseModel<?> getRestaurantRemoteModel() {
        return _restaurantRemoteModel;
    }

    public void setRestaurantRemoteModel(BaseModel<?> restaurantRemoteModel) {
        _restaurantRemoteModel = restaurantRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _restaurantRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_restaurantRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            RestaurantLocalServiceUtil.addRestaurant(this);
        } else {
            RestaurantLocalServiceUtil.updateRestaurant(this);
        }
    }

    @Override
    public String[] getAvailableLanguageIds() {
        Set<String> availableLanguageIds = new TreeSet<String>();

        Map<Locale, String> nameMap = getNameMap();

        for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        Map<Locale, String> logoDescriptionMap = getLogoDescriptionMap();

        for (Map.Entry<Locale, String> entry : logoDescriptionMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        Map<Locale, String> descriptionMap = getDescriptionMap();

        for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
    }

    @Override
    public String getDefaultLanguageId() {
        String xml = getName();

        if (xml == null) {
            return StringPool.BLANK;
        }

        return LocalizationUtil.getDefaultLanguageId(xml);
    }

    @Override
    public void prepareLocalizedFieldsForImport() throws LocaleException {
        prepareLocalizedFieldsForImport(null);
    }

    @Override
    @SuppressWarnings("unused")
    public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
        throws LocaleException {
        Locale defaultLocale = LocaleUtil.getDefault();

        String modelDefaultLanguageId = getDefaultLanguageId();

        String name = getName(defaultLocale);

        if (Validator.isNull(name)) {
            setName(getName(modelDefaultLanguageId), defaultLocale);
        } else {
            setName(getName(defaultLocale), defaultLocale, defaultLocale);
        }

        String logoDescription = getLogoDescription(defaultLocale);

        if (Validator.isNull(logoDescription)) {
            setLogoDescription(getLogoDescription(modelDefaultLanguageId),
                defaultLocale);
        } else {
            setLogoDescription(getLogoDescription(defaultLocale),
                defaultLocale, defaultLocale);
        }

        String description = getDescription(defaultLocale);

        if (Validator.isNull(description)) {
            setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
        } else {
            setDescription(getDescription(defaultLocale), defaultLocale,
                defaultLocale);
        }
    }

    @Override
    public Restaurant toEscapedModel() {
        return (Restaurant) ProxyUtil.newProxyInstance(Restaurant.class.getClassLoader(),
            new Class[] { Restaurant.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RestaurantClp clone = new RestaurantClp();

        clone.setUuid(getUuid());
        clone.setRestaurantId(getRestaurantId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setStatus(getStatus());
        clone.setStatusByUserId(getStatusByUserId());
        clone.setStatusByUserName(getStatusByUserName());
        clone.setStatusDate(getStatusDate());
        clone.setEmailAddress(getEmailAddress());
        clone.setName(getName());
        clone.setCountryId(getCountryId());
        clone.setRegionId(getRegionId());
        clone.setPhoneNumber(getPhoneNumber());
        clone.setStreet1(getStreet1());
        clone.setStreet2(getStreet2());
        clone.setZip(getZip());
        clone.setCity(getCity());
        clone.setLogoId(getLogoId());
        clone.setLogoDescription(getLogoDescription());
        clone.setDescription(getDescription());

        return clone;
    }

    @Override
    public int compareTo(Restaurant restaurant) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(), restaurant.getCreateDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RestaurantClp)) {
            return false;
        }

        RestaurantClp restaurant = (RestaurantClp) obj;

        long primaryKey = restaurant.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(49);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", restaurantId=");
        sb.append(getRestaurantId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", statusByUserId=");
        sb.append(getStatusByUserId());
        sb.append(", statusByUserName=");
        sb.append(getStatusByUserName());
        sb.append(", statusDate=");
        sb.append(getStatusDate());
        sb.append(", emailAddress=");
        sb.append(getEmailAddress());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", countryId=");
        sb.append(getCountryId());
        sb.append(", regionId=");
        sb.append(getRegionId());
        sb.append(", phoneNumber=");
        sb.append(getPhoneNumber());
        sb.append(", street1=");
        sb.append(getStreet1());
        sb.append(", street2=");
        sb.append(getStreet2());
        sb.append(", zip=");
        sb.append(getZip());
        sb.append(", city=");
        sb.append(getCity());
        sb.append(", logoId=");
        sb.append(getLogoId());
        sb.append(", logoDescription=");
        sb.append(getLogoDescription());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(76);

        sb.append("<model><model-name>");
        sb.append("com.smile.plugins.model.Restaurant");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>restaurantId</column-name><column-value><![CDATA[");
        sb.append(getRestaurantId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
        sb.append(getStatusByUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
        sb.append(getStatusByUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statusDate</column-name><column-value><![CDATA[");
        sb.append(getStatusDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailAddress</column-name><column-value><![CDATA[");
        sb.append(getEmailAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>countryId</column-name><column-value><![CDATA[");
        sb.append(getCountryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>regionId</column-name><column-value><![CDATA[");
        sb.append(getRegionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
        sb.append(getPhoneNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>street1</column-name><column-value><![CDATA[");
        sb.append(getStreet1());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>street2</column-name><column-value><![CDATA[");
        sb.append(getStreet2());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>zip</column-name><column-value><![CDATA[");
        sb.append(getZip());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>city</column-name><column-value><![CDATA[");
        sb.append(getCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>logoId</column-name><column-value><![CDATA[");
        sb.append(getLogoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>logoDescription</column-name><column-value><![CDATA[");
        sb.append(getLogoDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
