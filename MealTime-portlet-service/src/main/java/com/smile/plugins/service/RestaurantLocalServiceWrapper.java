package com.smile.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RestaurantLocalService}.
 *
 * @author guillaume Lenoir
 * @see RestaurantLocalService
 * @generated
 */
public class RestaurantLocalServiceWrapper implements RestaurantLocalService,
    ServiceWrapper<RestaurantLocalService> {
    private RestaurantLocalService _restaurantLocalService;

    public RestaurantLocalServiceWrapper(
        RestaurantLocalService restaurantLocalService) {
        _restaurantLocalService = restaurantLocalService;
    }

    /**
    * Adds the restaurant to the database. Also notifies the appropriate model listeners.
    *
    * @param restaurant the restaurant
    * @return the restaurant that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant addRestaurant(
        com.smile.plugins.model.Restaurant restaurant)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.addRestaurant(restaurant);
    }

    /**
    * Creates a new restaurant with the primary key. Does not add the restaurant to the database.
    *
    * @param restaurantId the primary key for the new restaurant
    * @return the new restaurant
    */
    @Override
    public com.smile.plugins.model.Restaurant createRestaurant(
        long restaurantId) {
        return _restaurantLocalService.createRestaurant(restaurantId);
    }

    /**
    * Deletes the restaurant with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param restaurantId the primary key of the restaurant
    * @return the restaurant that was removed
    * @throws PortalException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant deleteRestaurant(
        long restaurantId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.deleteRestaurant(restaurantId);
    }

    /**
    * Deletes the restaurant from the database. Also notifies the appropriate model listeners.
    *
    * @param restaurant the restaurant
    * @return the restaurant that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant deleteRestaurant(
        com.smile.plugins.model.Restaurant restaurant)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.deleteRestaurant(restaurant);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _restaurantLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.smile.plugins.model.Restaurant fetchRestaurant(long restaurantId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.fetchRestaurant(restaurantId);
    }

    /**
    * Returns the restaurant with the matching UUID and company.
    *
    * @param uuid the restaurant's UUID
    * @param companyId the primary key of the company
    * @return the matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant fetchRestaurantByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.fetchRestaurantByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the restaurant matching the UUID and group.
    *
    * @param uuid the restaurant's UUID
    * @param groupId the primary key of the group
    * @return the matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant fetchRestaurantByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.fetchRestaurantByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the restaurant with the primary key.
    *
    * @param restaurantId the primary key of the restaurant
    * @return the restaurant
    * @throws PortalException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant getRestaurant(long restaurantId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurant(restaurantId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the restaurant with the matching UUID and company.
    *
    * @param uuid the restaurant's UUID
    * @param companyId the primary key of the company
    * @return the matching restaurant
    * @throws PortalException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant getRestaurantByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurantByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the restaurant matching the UUID and group.
    *
    * @param uuid the restaurant's UUID
    * @param groupId the primary key of the group
    * @return the matching restaurant
    * @throws PortalException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant getRestaurantByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurantByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns a range of all the restaurants.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @return the range of restaurants
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.smile.plugins.model.Restaurant> getRestaurants(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurants(start, end);
    }

    /**
    * Returns the number of restaurants.
    *
    * @return the number of restaurants
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getRestaurantsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurantsCount();
    }

    /**
    * Updates the restaurant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param restaurant the restaurant
    * @return the restaurant that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.smile.plugins.model.Restaurant updateRestaurant(
        com.smile.plugins.model.Restaurant restaurant)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.updateRestaurant(restaurant);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _restaurantLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _restaurantLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _restaurantLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.smile.plugins.model.Restaurant addRestaurant(
        com.smile.plugins.model.Restaurant restaurant,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.addRestaurant(restaurant, serviceContext);
    }

    @Override
    public com.smile.plugins.model.Restaurant updateRestaurant(
        com.smile.plugins.model.Restaurant restaurant,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.updateRestaurant(restaurant,
            serviceContext);
    }

    @Override
    public void updateAsset(long userId,
        com.smile.plugins.model.Restaurant restaurant, long[] assetCategoryIds,
        java.lang.String[] assetTagNames, long[] assetLinkEntryIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _restaurantLocalService.updateAsset(userId, restaurant,
            assetCategoryIds, assetTagNames, assetLinkEntryIds);
    }

    @Override
    public java.util.List<com.smile.plugins.model.Restaurant> getRestaurantByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurantByGroupId(groupId);
    }

    @Override
    public java.util.List<com.smile.plugins.model.Restaurant> getRestaurantByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurantByGroupId(groupId, start,
            end);
    }

    @Override
    public java.util.List<com.smile.plugins.model.Restaurant> getRestaurantByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurantByGroupId(groupId, start,
            end, orderByComparator);
    }

    @Override
    public int getRestaurantsCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.getRestaurantsCountByGroupId(groupId);
    }

    @Override
    public com.smile.plugins.model.Restaurant updateStatus(long userId,
        long resourcePrimKey, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _restaurantLocalService.updateStatus(userId, resourcePrimKey,
            status, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public RestaurantLocalService getWrappedRestaurantLocalService() {
        return _restaurantLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedRestaurantLocalService(
        RestaurantLocalService restaurantLocalService) {
        _restaurantLocalService = restaurantLocalService;
    }

    @Override
    public RestaurantLocalService getWrappedService() {
        return _restaurantLocalService;
    }

    @Override
    public void setWrappedService(RestaurantLocalService restaurantLocalService) {
        _restaurantLocalService = restaurantLocalService;
    }
}
