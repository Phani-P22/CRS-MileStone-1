<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!--	<a class="LinkButton" href="">Change Personal Details</a>	 -->
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

<body>
	<h1 class="header">Professor Operations</h1>
	<div class="formContainer">
		<form id="form" class="inputForm">
			<div class="list">
				<table>
					<tr>
						<td class="td"><a class="LinkButton" href="ProfessorGradeStudents.jsp">Grade
								Students</a></td>
						<td class="td"><a class="LinkButton" href="ProfessorViewDetails.jsp">View
								Details</a></td>
					</tr>

					<tr>

						<td class="td"><a class="LinkButton"
							href="ProfessorTeachingAllStudentDetails.jsp">View All
								Students You Teach</a></td>
						<td class="td"><a class="LinkButton"
							href="PrintProfessorTeachingCourseDetails.jsp">View Course
								Details</a></td>

					</tr>

					<tr>

						<td class="td"><a class="LinkButton" href="ProfessorCourseChangeApply.jsp">Change
								Course You Teach</a></td>
						<td class="td"><a class="LinkButton" href="">Change Personal Details</a></td>

					</tr>

					<tr>

						<td class="td"><a class="LinkButton" href="ProfessorChangeUserName.jsp">Change
								UserName</a></td>
						<td class="td"><a class="LinkButton" href="ProfessorChangePassword.jsp">Change
								Password</a></td>

					</tr>

				</table>
				<br>
				<div class="buttonHolder">
					<a class="LinkButton" class="LinkButton" id="professorLogOut" href="professorLogOut">Logout</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>