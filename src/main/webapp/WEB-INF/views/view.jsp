<%@include file="init.jsp"%>
<portlet:renderURL var="backToList" />
<p>
<liferay-ui:header title="Back to persons List" backURL="${backToList}" backLabel="Back"></liferay-ui:header>
</p>
<c:choose>
	<c:when test="${empty person}">
		Person not found
	</c:when>
	<c:otherwise>
		<div class="form-horizontal">
			<fieldset>
				<div class="control-group">
					<span class="control-label"><strong>First name</strong></span>
					<span class="controls">${person.firstName}</span>
				</div>
				<div class="control-group">
					<span class="control-label"><strong>Last name</strong></span>
					<span class="controls">${person.lastName}</span>
				</div>
				<div class="control-group">
					<span class="control-label"><strong>Birthday</strong></span>
					<span class="controls">${person.birthday}</span>
				</div>					
			</fieldset>
		</div>
	</c:otherwise>
</c:choose>