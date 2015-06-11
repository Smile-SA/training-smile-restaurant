<%@page import="com.smile.plugins.Permissions.RestaurantPermission"%>
<%@page import="com.smile.plugins.model.Restaurant"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Restaurant restaurant = (Restaurant)row.getObject();

String name = Restaurant.class.getName();
long restaurantId = restaurant.getRestaurantId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
		<c:if test="<%= RestaurantPermission.contains(permissionChecker, restaurant, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/restaurants/edit.jsp" />
			<portlet:param name="restaurantId" value="<%= String.valueOf(restaurantId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />
	</c:if>

	<c:if test="<%= RestaurantPermission.contains(permissionChecker, restaurant, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteRestaurant" var="deleteURL">
			<portlet:param name="restaurantId" value="<%= String.valueOf(restaurantId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%= RestaurantPermission.contains(permissionChecker, restaurant, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Restaurant.class.getName() %>"
			modelResourceDescription="<%= restaurant.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(restaurantId) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
	    
</liferay-ui:icon-menu>