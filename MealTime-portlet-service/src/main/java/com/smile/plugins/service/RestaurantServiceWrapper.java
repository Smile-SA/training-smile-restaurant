package com.smile.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RestaurantService}.
 *
 * @author guillaume Lenoir
 * @see RestaurantService
 * @generated
 */
public class RestaurantServiceWrapper implements RestaurantService,
    ServiceWrapper<RestaurantService> {
    private RestaurantService _restaurantService;

    public RestaurantServiceWrapper(RestaurantService restaurantService) {
        _restaurantService = restaurantService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _restaurantService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _restaurantService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _restaurantService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.smile.plugins.model.Restaurant addRestaurant(
        com.smile.plugins.model.Restaurant restaurant,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _restaurantService.addRestaurant(restaurant, serviceContext);
    }

    @Override
    public com.smile.plugins.model.Restaurant updateRestaurant(
        com.smile.plugins.model.Restaurant restaurant,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _restaurantService.updateRestaurant(restaurant, serviceContext);
    }

    @Override
    public com.smile.plugins.model.Restaurant deleteRestaurant(
        long restaurantId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return _restaurantService.deleteRestaurant(restaurantId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public RestaurantService getWrappedRestaurantService() {
        return _restaurantService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedRestaurantService(RestaurantService restaurantService) {
        _restaurantService = restaurantService;
    }

    @Override
    public RestaurantService getWrappedService() {
        return _restaurantService;
    }

    @Override
    public void setWrappedService(RestaurantService restaurantService) {
        _restaurantService = restaurantService;
    }
}
