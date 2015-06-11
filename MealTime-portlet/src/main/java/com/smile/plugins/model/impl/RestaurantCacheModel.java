package com.smile.plugins.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.smile.plugins.model.Restaurant;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Restaurant in entity cache.
 *
 * @author guillaume Lenoir
 * @see Restaurant
 * @generated
 */
public class RestaurantCacheModel implements CacheModel<Restaurant>,
    Externalizable {
    public String uuid;
    public long restaurantId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;
    public String emailAddress;
    public String name;
    public long countryId;
    public long regionId;
    public String phoneNumber;
    public String street1;
    public String street2;
    public String zip;
    public String city;
    public long logoId;
    public String logoDescription;
    public String description;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(49);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", restaurantId=");
        sb.append(restaurantId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", status=");
        sb.append(status);
        sb.append(", statusByUserId=");
        sb.append(statusByUserId);
        sb.append(", statusByUserName=");
        sb.append(statusByUserName);
        sb.append(", statusDate=");
        sb.append(statusDate);
        sb.append(", emailAddress=");
        sb.append(emailAddress);
        sb.append(", name=");
        sb.append(name);
        sb.append(", countryId=");
        sb.append(countryId);
        sb.append(", regionId=");
        sb.append(regionId);
        sb.append(", phoneNumber=");
        sb.append(phoneNumber);
        sb.append(", street1=");
        sb.append(street1);
        sb.append(", street2=");
        sb.append(street2);
        sb.append(", zip=");
        sb.append(zip);
        sb.append(", city=");
        sb.append(city);
        sb.append(", logoId=");
        sb.append(logoId);
        sb.append(", logoDescription=");
        sb.append(logoDescription);
        sb.append(", description=");
        sb.append(description);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Restaurant toEntityModel() {
        RestaurantImpl restaurantImpl = new RestaurantImpl();

        if (uuid == null) {
            restaurantImpl.setUuid(StringPool.BLANK);
        } else {
            restaurantImpl.setUuid(uuid);
        }

        restaurantImpl.setRestaurantId(restaurantId);
        restaurantImpl.setGroupId(groupId);
        restaurantImpl.setCompanyId(companyId);
        restaurantImpl.setUserId(userId);

        if (userName == null) {
            restaurantImpl.setUserName(StringPool.BLANK);
        } else {
            restaurantImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            restaurantImpl.setCreateDate(null);
        } else {
            restaurantImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            restaurantImpl.setModifiedDate(null);
        } else {
            restaurantImpl.setModifiedDate(new Date(modifiedDate));
        }

        restaurantImpl.setStatus(status);
        restaurantImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            restaurantImpl.setStatusByUserName(StringPool.BLANK);
        } else {
            restaurantImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            restaurantImpl.setStatusDate(null);
        } else {
            restaurantImpl.setStatusDate(new Date(statusDate));
        }

        if (emailAddress == null) {
            restaurantImpl.setEmailAddress(StringPool.BLANK);
        } else {
            restaurantImpl.setEmailAddress(emailAddress);
        }

        if (name == null) {
            restaurantImpl.setName(StringPool.BLANK);
        } else {
            restaurantImpl.setName(name);
        }

        restaurantImpl.setCountryId(countryId);
        restaurantImpl.setRegionId(regionId);

        if (phoneNumber == null) {
            restaurantImpl.setPhoneNumber(StringPool.BLANK);
        } else {
            restaurantImpl.setPhoneNumber(phoneNumber);
        }

        if (street1 == null) {
            restaurantImpl.setStreet1(StringPool.BLANK);
        } else {
            restaurantImpl.setStreet1(street1);
        }

        if (street2 == null) {
            restaurantImpl.setStreet2(StringPool.BLANK);
        } else {
            restaurantImpl.setStreet2(street2);
        }

        if (zip == null) {
            restaurantImpl.setZip(StringPool.BLANK);
        } else {
            restaurantImpl.setZip(zip);
        }

        if (city == null) {
            restaurantImpl.setCity(StringPool.BLANK);
        } else {
            restaurantImpl.setCity(city);
        }

        restaurantImpl.setLogoId(logoId);

        if (logoDescription == null) {
            restaurantImpl.setLogoDescription(StringPool.BLANK);
        } else {
            restaurantImpl.setLogoDescription(logoDescription);
        }

        if (description == null) {
            restaurantImpl.setDescription(StringPool.BLANK);
        } else {
            restaurantImpl.setDescription(description);
        }

        restaurantImpl.resetOriginalValues();

        return restaurantImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        restaurantId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        status = objectInput.readInt();
        statusByUserId = objectInput.readLong();
        statusByUserName = objectInput.readUTF();
        statusDate = objectInput.readLong();
        emailAddress = objectInput.readUTF();
        name = objectInput.readUTF();
        countryId = objectInput.readLong();
        regionId = objectInput.readLong();
        phoneNumber = objectInput.readUTF();
        street1 = objectInput.readUTF();
        street2 = objectInput.readUTF();
        zip = objectInput.readUTF();
        city = objectInput.readUTF();
        logoId = objectInput.readLong();
        logoDescription = objectInput.readUTF();
        description = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(restaurantId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeInt(status);
        objectOutput.writeLong(statusByUserId);

        if (statusByUserName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statusByUserName);
        }

        objectOutput.writeLong(statusDate);

        if (emailAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(emailAddress);
        }

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeLong(countryId);
        objectOutput.writeLong(regionId);

        if (phoneNumber == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(phoneNumber);
        }

        if (street1 == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(street1);
        }

        if (street2 == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(street2);
        }

        if (zip == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(zip);
        }

        if (city == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(city);
        }

        objectOutput.writeLong(logoId);

        if (logoDescription == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(logoDescription);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }
    }
}
