package com.smile.plugins.service.base;

import com.smile.plugins.service.RestaurantServiceUtil;

import java.util.Arrays;

/**
 * @author guillaume Lenoir
 * @generated
 */
public class RestaurantServiceClpInvoker {
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;
    private String _methodName54;
    private String[] _methodParameterTypes54;

    public RestaurantServiceClpInvoker() {
        _methodName46 = "getBeanIdentifier";

        _methodParameterTypes46 = new String[] {  };

        _methodName47 = "setBeanIdentifier";

        _methodParameterTypes47 = new String[] { "java.lang.String" };

        _methodName52 = "addRestaurant";

        _methodParameterTypes52 = new String[] {
                "com.smile.plugins.model.Restaurant",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName53 = "updateRestaurant";

        _methodParameterTypes53 = new String[] {
                "com.smile.plugins.model.Restaurant",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName54 = "deleteRestaurant";

        _methodParameterTypes54 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return RestaurantServiceUtil.getBeanIdentifier();
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            RestaurantServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return RestaurantServiceUtil.addRestaurant((com.smile.plugins.model.Restaurant) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return RestaurantServiceUtil.updateRestaurant((com.smile.plugins.model.Restaurant) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return RestaurantServiceUtil.deleteRestaurant(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
