package com.smile.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.smile.plugins.service.http.RestaurantServiceSoap}.
 *
 * @author guillaume Lenoir
 * @see com.smile.plugins.service.http.RestaurantServiceSoap
 * @generated
 */
public class RestaurantSoap implements Serializable {
    private String _uuid;
    private long _restaurantId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private int _status;
    private long _statusByUserId;
    private String _statusByUserName;
    private Date _statusDate;
    private String _emailAddress;
    private String _name;
    private long _countryId;
    private long _regionId;
    private String _phoneNumber;
    private String _street1;
    private String _street2;
    private String _zip;
    private String _city;
    private long _logoId;
    private String _logoDescription;
    private String _description;

    public RestaurantSoap() {
    }

    public static RestaurantSoap toSoapModel(Restaurant model) {
        RestaurantSoap soapModel = new RestaurantSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setRestaurantId(model.getRestaurantId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setStatus(model.getStatus());
        soapModel.setStatusByUserId(model.getStatusByUserId());
        soapModel.setStatusByUserName(model.getStatusByUserName());
        soapModel.setStatusDate(model.getStatusDate());
        soapModel.setEmailAddress(model.getEmailAddress());
        soapModel.setName(model.getName());
        soapModel.setCountryId(model.getCountryId());
        soapModel.setRegionId(model.getRegionId());
        soapModel.setPhoneNumber(model.getPhoneNumber());
        soapModel.setStreet1(model.getStreet1());
        soapModel.setStreet2(model.getStreet2());
        soapModel.setZip(model.getZip());
        soapModel.setCity(model.getCity());
        soapModel.setLogoId(model.getLogoId());
        soapModel.setLogoDescription(model.getLogoDescription());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static RestaurantSoap[] toSoapModels(Restaurant[] models) {
        RestaurantSoap[] soapModels = new RestaurantSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RestaurantSoap[][] toSoapModels(Restaurant[][] models) {
        RestaurantSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RestaurantSoap[models.length][models[0].length];
        } else {
            soapModels = new RestaurantSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RestaurantSoap[] toSoapModels(List<Restaurant> models) {
        List<RestaurantSoap> soapModels = new ArrayList<RestaurantSoap>(models.size());

        for (Restaurant model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RestaurantSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _restaurantId;
    }

    public void setPrimaryKey(long pk) {
        setRestaurantId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getRestaurantId() {
        return _restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        _restaurantId = restaurantId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public long getStatusByUserId() {
        return _statusByUserId;
    }

    public void setStatusByUserId(long statusByUserId) {
        _statusByUserId = statusByUserId;
    }

    public String getStatusByUserName() {
        return _statusByUserName;
    }

    public void setStatusByUserName(String statusByUserName) {
        _statusByUserName = statusByUserName;
    }

    public Date getStatusDate() {
        return _statusDate;
    }

    public void setStatusDate(Date statusDate) {
        _statusDate = statusDate;
    }

    public String getEmailAddress() {
        return _emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public long getCountryId() {
        return _countryId;
    }

    public void setCountryId(long countryId) {
        _countryId = countryId;
    }

    public long getRegionId() {
        return _regionId;
    }

    public void setRegionId(long regionId) {
        _regionId = regionId;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber = phoneNumber;
    }

    public String getStreet1() {
        return _street1;
    }

    public void setStreet1(String street1) {
        _street1 = street1;
    }

    public String getStreet2() {
        return _street2;
    }

    public void setStreet2(String street2) {
        _street2 = street2;
    }

    public String getZip() {
        return _zip;
    }

    public void setZip(String zip) {
        _zip = zip;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public long getLogoId() {
        return _logoId;
    }

    public void setLogoId(long logoId) {
        _logoId = logoId;
    }

    public String getLogoDescription() {
        return _logoDescription;
    }

    public void setLogoDescription(String logoDescription) {
        _logoDescription = logoDescription;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
