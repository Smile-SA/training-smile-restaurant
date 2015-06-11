<%@page import="com.smile.plugins.model.Restaurant"%>
<%@include file="/html/init.jsp" %>

<aui:container>
	<aui:row>
		<div class="span5">
			<aui:row fluid="true">
				<c:if test="${restaurant.logoId > 0}">
					  <img title="${restaurant.getLogoDescription(locale)}" alt="${restaurant.getLogoDescription(locale)}" src="${restaurant.getLogoSrc(themeDisplay)}" /> 
				 </c:if>
			</aui:row>
		</div>
		<div class="span5 offset1">
			<aui:row cssClass="well" fluid="true">
					<p><i class="icon-user"></i> <liferay-ui:message key="name"/> : ${restaurant.getName(locale)}</p>
					<p><i class="icon-phone"></i> <liferay-ui:message key="phoneNumber"/> : ${restaurant.phoneNumber}</p>
			</aui:row>
		</div>
	</aui:row>
			
	<aui:row>
		<p>
			${description}
		</p>
	</aui:row>
	
	<aui:row>
		
		<h5>Vote !!!! </h5>
		
		<liferay-ui:ratings
			className="<%= Restaurant.class.getName() %>"
			classPK="${restaurant.getRestaurantId()}"
		/>
		<br/>
	</aui:row>
	
	
</aui:container>