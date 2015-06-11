<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.model.Address"%>
<%@page import="com.smile.plugins.DuplicateRestaurantEmailAddressException"%>
<%@page import="com.smile.plugins.DuplicateRestaurantEmailAddressExceptionException"%>
<%@page import="com.smile.plugins.service.RestaurantLocalServiceUtil"%>
<%@page import="com.smile.plugins.model.Restaurant"%>
<%@page import="com.liferay.portal.DuplicateUserEmailAddressException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/html/init.jsp" %>

<%
	Restaurant restaurant = null;
	long countryId = 0l;
	long regionId = 0l;

	long restaurantId = ParamUtil.getLong(request, "restaurantId");
	boolean isMale = false;
	String languageId = themeDisplay.getLanguageId();
	String description = StringPool.BLANK;
	
	long logoId = 0;
	
	if (restaurantId > 0) {
		restaurant = RestaurantLocalServiceUtil.getRestaurant(restaurantId);
		countryId = restaurant.getCountryId();
		regionId = restaurant.getRegionId();
		logoId = restaurant.getLogoId();
		description = HtmlUtil.escapeJS(restaurant.getDescription(locale));
	}

	String redirect = ParamUtil.getString(request, "redirect");
	
	String publishButtonLabel = "save-Restaurant";

	if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), Restaurant.class.getName())) {
		publishButtonLabel = "submit-for-publication";
	}
	
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (restaurant != null) ? restaurant.getName(locale) : "new-restaurant" %>'
/>

<aui:model-context bean="<%= restaurant %>" model="<%= Restaurant.class %>" />

<portlet:actionURL name='<%= restaurant == null ? "addRestaurant" : "updateRestaurant" %>' var="editRestaurantURL" windowState="normal" />

<aui:form action="${editRestaurantURL}" enctype="multipart/form-data" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="restaurantId"/>
		
		<liferay-ui:error key="restaurant-name-required" message="restaurant-name-required" />
		<aui:input name="name" >
			<aui:validator name="minLength">2</aui:validator>
			<aui:validator name="required"/>
		</aui:input>

		<liferay-ui:error key="restaurant-emailAddress-required" message="restaurant-emailAddress-required" />
		<aui:input name="emailAddress">
			<aui:validator name="minLength">6</aui:validator>
			<aui:validator name="required"/>
			<aui:validator name="email"/>
		</aui:input>
		
		<liferay-ui:error key="restaurant-phoneNumber-required" message="restaurant-phoneNumber-required" />
		<aui:input name="phoneNumber">
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="minLength">8</aui:validator>
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>
		
		<liferay-ui:error key="restaurant-zip-required" message="restaurant-zip-required" />
		<aui:input name="zip" label="postal-code">
			<aui:validator name="minLength">2</aui:validator>
			<aui:validator name="required"/>
		</aui:input>
		
		<liferay-ui:error key="restaurant-street2-required" message="restaurant-street2-required" />
		<aui:input name="street1" label="Adresse 1 (Adresse)">
			<aui:validator name="minLength">2</aui:validator>
			<aui:validator name="required"/>
		</aui:input>
		
		<liferay-ui:error key="restaurant-street2-required" message="restaurant-street2-required" />
		<aui:input name="street2" label="Adresse 2 (Etage, Bâtiment)">
			<aui:validator name="minLength">2</aui:validator>
			<aui:validator name="required"/>
		</aui:input>
		
		<liferay-ui:error key="restaurant-city-required" message="restaurant-city-required" />
		<aui:input name="city" label="city">
			<aui:validator name="minLength">2</aui:validator>
			<aui:validator name="required"/>
		</aui:input>

		<aui:input name="logoDescription" label="logo-description">
		</aui:input>
		
		<c:if test="<%= logoId > 0 %>">
		 	  <liferay-ui:message key="logo"/> :
		 	  <br>
			  <img alt="logo" src="<%= restaurant.getLogoSrc(themeDisplay) %>" /> 
		 </c:if>
		<aui:input inlineField="true" name="logo" type="file" label="Logo">
			<aui:validator name="acceptFiles">'jpg,png,tif,gif'</aui:validator>
		</aui:input>
		
		<aui:select label="country" name="countryId" showEmptyOption="true" />
		
		<aui:select label="region" name="regionId" showEmptyOption="true" />

		<aui:input name="categories" type="assetCategories" />
		
		<aui:field-wrapper label="content" name="editor">
			<liferay-ui:input-editor name="editor" resizable="true"></liferay-ui:input-editor>
		</aui:field-wrapper>
	
		<aui:input name="tags" type="assetTags" />
	</aui:fieldset>

	<c:if test="<%= Validator.isNull(restaurant) %>">
		<aui:field-wrapper label="permissions">
			<liferay-ui:input-permissions
				modelName="<%= Restaurant.class.getName() %>"
				/>
		</aui:field-wrapper>
	</c:if>
	
	<aui:button-row>
		<aui:button type="submit" value="<%= publishButtonLabel %>" onClick="${renderResponse.getNamespace()}extractCodeFromEditor();" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
	    
</aui:form>

<aui:script use="aui-base,liferay-dynamic-select">
	new Liferay.DynamicSelect(
		[
			{
				select: '<portlet:namespace />countryId',
				selectData: Liferay.Address.getCountries,
				selectDesc: 'nameCurrentValue',
				selectSort: 'true',
				selectId: 'countryId',
				selectVal: '<%= countryId %>'
			},
			{
				select: '<portlet:namespace />regionId',
				selectData: Liferay.Address.getRegions,
				selectDesc: 'name',
				selectId: 'regionId',
				selectVal: '<%= regionId %>'
			}
		]
	);
	
</aui:script>

<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= description %>";
	}
	
	function <portlet:namespace />extractCodeFromEditor() {
	   document.<portlet:namespace />fm.<portlet:namespace />editor.value = window.<portlet:namespace />editor.getHTML();
	}
</aui:script>