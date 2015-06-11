<%@include file="/html/init.jsp" %>

<aui:container>
	<aui:row >
		<aui:col width="80">
			<aui:row fluid="true" cssClass="well">
					<p><i class="icon-user"></i> <liferay-ui:message key="firstName"/> : ${restaurant.getName(locale)}</p>
					<p>
						<i class="icon-envelope"></i>
						 ${restaurant.getEmailAddress()}
					</p>
					<p><i class="icon-globe"></i> <liferay-ui:message key="country"/> : ${restaurant.getCountry(locale)}</p>
			</aui:row>
		</aui:col>
	</aui:row>
</aui:container>

<aui:container>
	<aui:row >
		<aui:col width="80">
			<aui:row fluid="true" cssClass="well">
					<p><i class="icon-phone"></i> <liferay-ui:message key="phoneNumber"/> : ${restaurant.phoneNumber}</p>
					<p><i class="icon-home"></i> <liferay-ui:message key="street1"/> : ${restaurant.street1}</p>
					<p><i class="icon-home"></i> <liferay-ui:message key="street2"/> : ${restaurant.street2}</p>
					<p><i class="icon-home"></i> <liferay-ui:message key="postal-code"/> : ${restaurant.zip}</p>
					 
					 <c:if test="${restaurant.logoId > 0}">
					 	  <br>
						  <img title="${restaurant.getLogoDescription(locale)}" alt="${restaurant.getLogoDescription(locale)}" src="${restaurant.getLogoSrc(themeDisplay)}" /> 
					 </c:if>
					 
					 <br>
					 <p>
					  <p><i class="icon-edit-sign"></i> <liferay-ui:message key="description"/> :  ${restaurant.getDescription(locale)}</p>
					 <p>
			</aui:row>
		</aui:col>
	</aui:row>
</aui:container>


