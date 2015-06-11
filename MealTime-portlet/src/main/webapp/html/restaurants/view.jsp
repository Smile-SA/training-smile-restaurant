<%@include file="/html/init.jsp" %>

<liferay-ui:success key="restaurant-added" message="restaurant-added-successfully" />
<liferay-ui:success key="restaurant-updated" message="restaurant-updated-successfully" />
<liferay-ui:success key="restaurant-deleted" message="restaurant-deleted-successfully" />

<liferay-ui:error key="restaurant-errors" message="restaurant-errors" />

<c:if test="${hasAddRight}">

	<portlet:renderURL var="addURL">
		<portlet:param name="mvcPath" value="/html/restaurants/edit.jsp" />
		<portlet:param name="redirect" value='<%= PortalUtil.getCurrentURL(renderRequest) %>'/>
	</portlet:renderURL>
	
	<aui:row>
		<div class="pull-right" >
			<a class="btn btn-info btn-large" href="${addURL}">
	  		<i class="icon-plus-sign icon-large"></i>  <liferay-ui:message key="add-restaurant"></liferay-ui:message></a>
		</div>
	</aui:row>
</c:if>
<br>

<liferay-ui:search-container  searchContainer="${searchRestaurantContainer}" var="searchRestaurantContainer">
	<liferay-ui:search-container-results
		results="${searchRestaurantContainer.results}"
		total="${searchRestaurantContainer.total}"
	/>

	<liferay-ui:search-container-row
		className="com.smile.plugins.model.Restaurant"
		keyProperty="restaurantId"
		modelVar="restaurant" escapedModel="true" 
	>

		<liferay-ui:search-container-column-text
			name="email-address"
			property="emailAddress"
		/>
		
		<liferay-ui:search-container-column-text
			name="name"
			property="name"
		/>
		
		<liferay-ui:search-container-column-text
			name="status"
			value="${restaurant.getStatus(locale)}"
		/>
		
		<liferay-ui:search-container-column-text
			name="country"
			value="${restaurant.getCountry(locale)}"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			name="Actions"
			path="/html/restaurants/actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="${searchRestaurantContainer}"/>
</liferay-ui:search-container>
