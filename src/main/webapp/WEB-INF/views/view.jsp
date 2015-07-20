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
				<div class="span12">
					<span class="span2"><strong>First name</strong></span>
					<span class="span10">${person.firstName}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong>Last name</strong></span>
					<span class="span10">${person.lastName}</span>
				</div>
				<div class="span12">
					<span class="span2"><strong>Birthday</strong></span>
					<span class="span10">${person.birthday}</span>
				</div>					
			</fieldset>
		</div>
	</c:otherwise>
</c:choose>