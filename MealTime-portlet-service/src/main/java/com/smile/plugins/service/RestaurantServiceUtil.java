package com.smile.plugins.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Restaurant. This utility wraps
 * {@link com.smile.plugins.service.impl.RestaurantServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author guillaume Lenoir
 * @see RestaurantService
 * @see com.smile.plugins.service.base.RestaurantServiceBaseImpl
 * @see com.smile.plugins.service.impl.RestaurantServiceImpl
 * @generated
 */
public class RestaurantServiceUtil {
    private static RestaurantService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.smile.plugins.service.impl.RestaurantServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.smile.plugins.model.Restaurant addRestaurant(
        com.smile.plugins.model.Restaurant restaurant,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().addRestaurant(restaurant, serviceContext);
    }

    public static com.smile.plugins.model.Restaurant updateRestaurant(
        com.smile.plugins.model.Restaurant restaurant,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().updateRestaurant(restaurant, serviceContext);
    }

    public static com.smile.plugins.model.Restaurant deleteRestaurant(
        long restaurantId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.liferay.portal.security.auth.PrincipalException {
        return getService().deleteRestaurant(restaurantId);
    }

    public static void clearService() {
        _service = null;
    }

    public static RestaurantService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    RestaurantService.class.getName());

            if (invokableService instanceof RestaurantService) {
                _service = (RestaurantService) invokableService;
            } else {
                _service = new RestaurantServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(RestaurantServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(RestaurantService service) {
    }
}
