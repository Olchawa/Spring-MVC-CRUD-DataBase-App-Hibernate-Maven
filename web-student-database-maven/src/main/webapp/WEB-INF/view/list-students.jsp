<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
	<title>Student Database</title>
	
	<meta name="description" content="Simple web database app">
	<meta name="keywords" content="student">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<link href="<c:url value="/resources/css/list.css" />" rel="stylesheet">
   
     
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="60">

	<div class ="container-fluid">

		<header>
			
			<nav class="navbar navbar-inverse navbar-fixed-top">
			  <div class="navbar-header">
			    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			      <span class="icon-bar"></span>
			      <span class="icon-bar"></span>              
			    </button>
			    <a class="navbar-brand" href="#">Student Database Manager</a>
			  </div>
			  <div>
			    <div class="collapse navbar-collapse" id="myNavbar">
			      <ul class="nav navbar-nav">
			        <li><a href="showAddForm">Add Student</a></li>	  
				        <li class="dropdown">
				        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Sort
				        <span class="caret"></span></a>
				        <ul class="dropdown-menu">
				          <li><a href="sortByFirstName">By First Name</a></li>
				          <li><a href="list">By Last Name</a></li>
				        </ul>
			      </li>
			      </ul>
			    </div>
			  </nav>

		</header>

		<main>
		
		<article>

			<section>

				<div class="container">
				  <div class="table-responsive">        
					<table class="table table-hover"> 
						<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Age</th>
							<th>Email</th>
							<th>Country</th>
							<th>City</th>
							<th>Action</th>
						</tr>
						</thead>
						<tbody>
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
						</tbody>
					</table>		
					</div>
				</div>

			</section>

		</article>

		</main>

		<footer>	
			<div class="footer">
				Written and coded by Pawel Olchawa &copy; 2017 
			</div>
		</footer>

	</div>

</body>
</html>