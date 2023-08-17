<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Professor Pending Home</title>
<!--	<a class="LinkButton" class="LinkButton" href="">Change Personal Details</a>	 -->
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Professor</title>
</head>

<body>
	<h1 class="header">Professor Pending Operations</h1>
	<div class="formContainer">
		<form id="form" class="inputForm">
			<div class="list">
				<div class="buttonHolder">
					<p align="center">You are yet to be Approved by AdminTeam!</p>
				</div>
				<br>
				<table>
					<tr>
						<td class="td"><a class="LinkButton"
							href="ProfessorPendingViewDetails.jsp">View Application
								Details</a></td>
						<td class="td"><a class="LinkButton"
							href="ProfessorPendingCourseDetails.jsp">View Applied Course
								Details</a></td>
					</tr>

					<tr>

						<td class="td"><a class="LinkButton"
							href="ProfessorPendingChangeCourse.jsp">Change Course Applied</a></td>
						<td class="td"><a class="LinkButton"
							href="ProfessorWithDrawApplicationRequest.jsp">WithDraw
								Request</a></td>

					</tr>

				</table>
				<br>
				<div class="buttonHolder">
					<a class="LinkButton" class="LinkButton" class="LinkButton"
						id="professorLogOut" href="professorLogOut">Logout</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>