<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
						<td class="td"><a class="LinkButton"
							href="AdminViewStudentEnrollmentRequests.jsp">Handle Student
								Enrollment Requests</a></td>
						<td class="td"><a class="LinkButton"
							href="AdminViewProfessorApplicationRequests.jsp">Handle
								Professor Application Requests</a></td>
					</tr>

					<tr>

						<td class="td"><a class="LinkButton"
							href="AdminAddCourse.html">Register New Course</a></td>
						<td class="td"><a class="LinkButton"
							href="AdminRemoveCourse.jsp">DeRegister Course</a></td>

					</tr>

					<tr>

						<td class="td"><a class="LinkButton"
							href="AdminRemoveStudent.jsp">Remove Student</a></td>
						<td class="td"><a class="LinkButton"
							href="AdminViewAllStudents.jsp">View All Students</a></td>

					</tr>

					<tr>

						<td class="td"><a class="LinkButton"
							href="AdminRemoveProfessor.jsp">Remove Professor</a></td>
						<td class="td"><a class="LinkButton"
							href="AdminViewAllProfessors.jsp">View All Professors</a></td>

					</tr>

					<tr>

						<td class="td"><a class="LinkButton"
							href="AdminViewStudentCourseChangeRequests.jsp">View Student
								Course Change Requests</a></td>
						<td class="td"><a class="LinkButton"
							href="AdminViewProfessorCourseChangeRequests.jsp">View
								Professor Course Change Requests</a></td>

					</tr>

					<tr>
						<td class="td"><a class="LinkButton"
							href="AdminDeRegisterStudentGrades.jsp">DeRegister Student
								Grades</a></td>
						<td class="td"><a class="LinkButton"
							href="AdminViewAllCourses.jsp">View All Courses</a></td>
					</tr>

				</table>
				<br>
				<div class="buttonHolder">
					<a class="LinkButton" id="adminLogOut" href="adminLogOut">Logout</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>