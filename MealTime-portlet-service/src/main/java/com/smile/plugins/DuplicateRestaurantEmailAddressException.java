/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.smile.plugins;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author guillaume Lenoir
 */
public class DuplicateRestaurantEmailAddressException extends PortalException {

	public DuplicateRestaurantEmailAddressException() {
		super();
	}

	public DuplicateRestaurantEmailAddressException(String msg) {
		super(msg);
	}

	public DuplicateRestaurantEmailAddressException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateRestaurantEmailAddressException(Throwable cause) {
		super(cause);
	}

}