<%@include file="init.jsp"%>
<portlet:actionURL var="addPersonURL">
	<portlet:param name="action" value="save" />
</portlet:actionURL>
<portlet:renderURL var="backToList" />

<p>
	<liferay-ui:header title="Back to Student List" backURL="${backToList}"
		backLabel="Back"></liferay-ui:header>
</p>
<form:form id="edit" commandName="person" method="post"
	action="${addPersonURL}" cssClass="form-horizontal">
	<div id="rootwizard">
		<div class="control-group">
			<label class="control-label" for="firstname">First name<span
				class="required">*</span>
			</label>
			<div class="controls">
				<form:input path="firstName" cssClass="required alpha" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Last name<span
				class="required">*</span>
			</label>
			<div class="controls">
				<form:input path="lastName" cssClass="required alpha" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="birthday">Birthday</label>
			<div class="controls">
				<form:input path="birthday" />
			</div>
		</div>

		<div class="well well-large">
			<form:hidden path="id" />
			<button type="submit" class="btn btn-success button-submit">Save</button>
		</div>
	</div>
</form:form>