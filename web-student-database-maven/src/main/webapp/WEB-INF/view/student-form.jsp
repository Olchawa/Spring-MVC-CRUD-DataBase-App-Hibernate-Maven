<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
<title>Student Form</title>

<meta name="description" content="Student form">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">

</head>

<body data-spy="scroll" data-target=".navbar" data-offset="60">

	<div class="container-fluid">
		<header>
			<h1 class="title">Student Form</h1>
		</header>

		<main>
		<article>

			<section>

				<div class="well lead">
					<form:form action="saveStudent" modelAttribute="student"
						method="POST">
						<!-- associate data with customer id -->
						<form:hidden path="id" />

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="firstName">First
									Name:</label>
								<div class="col-md-7">
									<form:input type="text" path="firstName" id="firstName" placeholder="First name"
										class="form-control " />
									<div class="errors">
										<form:errors path="firstName" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="lastName">Last
									Name:</label>
								<div class="col-md-7">
									<form:input type="text" path="lastName" id="lastName" placeholder="Last name"
										class="form-control" />
									<div class="errors">
										<form:errors path="lastName" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="age">Age:</label>
								<div class="col-md-7">
									<form:input type="number" path="age" id="age" placeholder="Age"
										class="form-control " />
									<div class="errors">
										<form:errors path="age" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="email">Email:</label>
								<div class="col-md-7">
									<form:input type="text" path="email" id="email" placeholder="Email"
										class="form-control " />
									<div class="errors">
										<form:errors path="email" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="country">Country:</label>
								<div class="col-md-7">
									<form:input type="text" path="country" id="country" placeholder="Country"
										class="form-control " />
									<div class="errors">
										<form:errors path="country" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="city">City:</label>
								<div class="col-md-7">
									<form:input type="text" path="city" id="city" placeholder="City"
										class="form-control " />
									<div class="errors">
										<form:errors path="city" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-actions floatRight">
								<input type="submit" value="Submit"
									class="btn btn-primary" /> or <a
									href="<c:url value='/student/list' />">Cancel</a>
							</div>
						</div>
					</form:form>

				</div>

			</section>

		</article>
		</main>

		<footer>
			<div class="footer">Written and coded by Pawel Olchawa &copy;
				2017</div>
		</footer>
	</div>


</body>
</html>