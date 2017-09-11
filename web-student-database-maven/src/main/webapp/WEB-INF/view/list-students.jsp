<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>

	<title>Students List</title>
	
	<!-- reference style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Student Database Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			
			
			<!-- Add student button -->
			<input type = "button" value = "Add Student"
					onclick="window.location.href='showAddForm'; return false;"
					class ="add-button"/> 
		
			
			<!-- add  html table -->
			<table border="1"> 
					
					<c:url var="sortFisrtName" value="/student/sortByFirstName">
					</c:url>
					
					<c:url var="sortLastName" value="/student/list">						
					</c:url>
				<tr>
					<th><a href="${sortFisrtName}" >First Name</a></th>
					<th><a href="${sortLastName}"  >Last Name</a></th>
					<th>Age</th>
					<th>Email</th>
					<th>Country</th>
					<th>City</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempStudent" items="${students}">
				
					<c:url var="updateLink" value="/student/studentUpdateForm">
						<c:param name="studentId" value="${tempStudent.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/student/deleteStudent">
						<c:param name="studentId" value="${tempStudent.id}"/>
					</c:url>
				
					<tr>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName}</td>
						<td>${tempStudent.age}</td>
						<td>${tempStudent.email}</td>
						<td>${tempStudent.country}</td>
						<td>${tempStudent.city}</td>
						<td><a class ="actionHref" href="${updateLink}">Update</a> | 
						<a class ="actionHref"title="Confirm the action" href="${deleteLink}" onclick="if(!(confirm('Do yo want to delete this student?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>

			</table>
		
			

		</div>
	</div>

</body>

</html>