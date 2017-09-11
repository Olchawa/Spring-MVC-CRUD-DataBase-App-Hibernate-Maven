<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>

<title>Save Student</title>


<style>
.error {
	color: red
}
</style>

<!-- reference style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-student.css" />

<style>
.error {
	color: red
}
</style>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Student Database Manager</h2>
		</div>
	</div>


	<div id="container">

		<form:form action="saveStudent" modelAttribute="student" method="POST">

			<!-- associate data with customer id -->
			<form:hidden path="id" />

			<table style='table-layout: fixed'>
				<col width="140">
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td align="left"><form:input path="firstName" /></td>
						<td align="left"><form:errors path="firstName"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td align="left"><form:input path="lastName" /></td>
						<td align="left"><form:errors path="lastName"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Age:</label></td>
						<td align="left"><form:input path="age" /></td>
						<td align="left"><form:errors path="age" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td align="left"><form:input path="email" /></td>
						<td align="left"><form:errors path="email" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Country:</label></td>
						<td align="left"><form:input path="country" /></td>
						<td align="left"><form:errors path="country" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>City:</label></td>
						<td align="left"><form:input path="city" /></td>
						<td align="left"><form:errors path="city" cssClass="error" /></td>
					</tr>
					<tr>
						<td align="left"><label></label></td>
						<td align="left"><input type="submit" value="Save"
							class="save" /></td>
					</tr>
				</tbody>
			</table>

		</form:form>

		<!-- Add backToList button -->
		<input type="button" value="Back to list"
			onclick="window.location.href='list'; return false;"
			class="backToList " />


	</div>

</body>

</html>