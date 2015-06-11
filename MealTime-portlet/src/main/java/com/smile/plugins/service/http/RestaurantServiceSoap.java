package com.smile.plugins.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.smile.plugins.service.RestaurantServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.smile.plugins.service.RestaurantServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.smile.plugins.model.RestaurantSoap}.
 * If the method in the service utility returns a
 * {@link com.smile.plugins.model.Restaurant}, that is translated to a
 * {@link com.smile.plugins.model.RestaurantSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author guillaume Lenoir
 * @see RestaurantServiceHttp
 * @see com.smile.plugins.model.RestaurantSoap
 * @see com.smile.plugins.service.RestaurantServiceUtil
 * @generated
 */
public class RestaurantServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(RestaurantServiceSoap.class);

    public static com.smile.plugins.model.RestaurantSoap addRestaurant(
        com.smile.plugins.model.RestaurantSoap restaurant,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.smile.plugins.model.Restaurant returnValue = RestaurantServiceUtil.addRestaurant(com.smile.plugins.model.impl.RestaurantModelImpl.toModel(
                        restaurant), serviceContext);

            return com.smile.plugins.model.RestaurantSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.smile.plugins.model.RestaurantSoap updateRestaurant(
        com.smile.plugins.model.RestaurantSoap restaurant,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.smile.plugins.model.Restaurant returnValue = RestaurantServiceUtil.updateRestaurant(com.smile.plugins.model.impl.RestaurantModelImpl.toModel(
                        restaurant), serviceContext);

            return com.smile.plugins.model.RestaurantSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.smile.plugins.model.RestaurantSoap deleteRestaurant(
        long restaurantId) throws RemoteException {
        try {
            com.smile.plugins.model.Restaurant returnValue = RestaurantServiceUtil.deleteRestaurant(restaurantId);

            return com.smile.plugins.model.RestaurantSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
