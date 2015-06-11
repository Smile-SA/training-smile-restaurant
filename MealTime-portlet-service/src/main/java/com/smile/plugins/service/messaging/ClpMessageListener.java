package com.smile.plugins.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.smile.plugins.service.ClpSerializer;
import com.smile.plugins.service.RestaurantLocalServiceUtil;
import com.smile.plugins.service.RestaurantServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            RestaurantLocalServiceUtil.clearService();

            RestaurantServiceUtil.clearService();
        }
    }
}
