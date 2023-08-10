<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!--	<a class="LinkButton" class="LinkButton" class="LinkButton" href="">Change Personal Details</a>	 -->
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>

<body>
	<h1 class="header">Admin Operations</h1>
	<div class="formContainer">
		<form id="form" class="inputForm">
			<div class="list">
				<table>
					<tr>
						<td class="td"><a class="LinkButton" href="PrintStudentDetails.jsp">View
								Application Details</a></td>
						<td class="td"><a class="LinkButton"
							href="PrintStudentEnrolledCourseDetails.jsp">View Applied
								Course Details</a></td>
					</tr>

					<tr>

						<td class="td"><a class="LinkButton"
							href="StudentPendingChangeCourseEnrolled.jsp">Change Course
								Applied</a></td>
						<td class="td"><a class="LinkButton" href="StudentWithDrawSignUpRequest.jsp">WithDraw
								Request</a></td>

					</tr>

				</table>
				<br>
				<div class="buttonHolder">
					<a class="LinkButton" class="LinkButton" class="LinkButton" class="LinkButton"
						id="studentLogOut" href="studentLogOut">Logout</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>

<!-- 	<a class="LinkButton" class="LinkButton" href="">Change Personal Details</a>
		<a class="LinkButton" class="LinkButton" href="">View Course Professor Details</a>
	 -->

