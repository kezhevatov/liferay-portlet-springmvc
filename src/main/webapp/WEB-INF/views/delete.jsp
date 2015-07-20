<%@include file="init.jsp"%>
<portlet:actionURL var="deletePersonURL">
	<portlet:param name="action" value="delete" />
</portlet:actionURL>
<portlet:renderURL var="backToList" />

<p>
	<liferay-ui:header title="Back to person list" backURL="${backToList}"
		backLabel="Back"></liferay-ui:header>
</p>
<form:form id="edit" commandName="person" method="post"
	action="${deletePersonURL}" cssClass="form-horizontal">
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
		<div class="well well-large">
			<form:hidden path="id" />
			<button type="submit" class="btn btn-danger button-submit">Delete</button>
		</div>
	</c:otherwise>
</c:choose>
</form:form>