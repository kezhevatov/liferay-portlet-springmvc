<%@include file="init.jsp"%>

<portlet:renderURL var="viewPersonUrl">
	<portlet:param name="render" value="view"/>
</portlet:renderURL>
<portlet:renderURL var="addPersonUrl">
	<portlet:param name="render" value="edit"/>
</portlet:renderURL>

<body>
    <h3>List of persons</h3>

	<p class="pull-right">
		<a href="${addPersonUrl}" class="btn btn-primary"> <i class="icon-plus"></i>add person</a>
	</p>

	<table class="table table-striped table-bordered" >
		<thead>
			<tr>
			<th width="5%">Id</th><th width="20%">First name</th><th width="20%">Last name</th><th width="10%">Birthday</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${persons}">
			<tr>
				<td>${person.id}</td>
				<td><a href="${viewPersonUrl}&personId=${person.id}">${person.firstName}</a></td>
				<td>${person.lastName}</td>
				<td>${person.birthday}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

