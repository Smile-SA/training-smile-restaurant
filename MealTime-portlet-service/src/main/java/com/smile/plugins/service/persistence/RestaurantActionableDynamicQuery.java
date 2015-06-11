package com.smile.plugins.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.smile.plugins.model.Restaurant;
import com.smile.plugins.service.RestaurantLocalServiceUtil;

/**
 * @author guillaume Lenoir
 * @generated
 */
public abstract class RestaurantActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RestaurantActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RestaurantLocalServiceUtil.getService());
        setClass(Restaurant.class);

        setClassLoader(com.smile.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("restaurantId");
    }
}
