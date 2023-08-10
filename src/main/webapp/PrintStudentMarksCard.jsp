<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>View All Students</title>
</head>

<body>
	<%
	session = request.getSession();
	Student curStudent = (Student) session.getAttribute("curStudent");
	int marks = curStudent.getMarksSecured();
	if (marks == -1) {
		session.setAttribute("title", "View Marks");
		session.setAttribute("message", "Marks are Yet to be Graded!");
		session.setAttribute("redirectLink", "StudentHome.jsp");
		response.sendRedirect("AppPrintMessage.jsp");
		return;
	}
	%>
	<h1 class="header">Score Card</h1>

	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Student ID</th>
					<th class="displayTableData">Student Name</th>
					<th class="displayTableData">Age</th>
					<th class="displayTableData">Course ID</th>
					<th class="displayTableData">Marks</th>
					<th class="displayTableData">Email ID</th>
				</tr>
				<tr>
					<td class="displayTableData"><%=curStudent.getStudentID()%></td>
					<td class="displayTableData"><%=curStudent.getStudentName()%></td>
					<td class="displayTableData"><%=curStudent.getAge()%></td>
					<td class="displayTableData"><%=curStudent.getCourseEnrolled()%></td>
					<td class="displayTableData"><%=curStudent.getMarksSecured()%></td>
					<td class="displayTableData"><%=curStudent.getEmailID()%></td>
				</tr>
			</table>
			<div class="buttonHolder">
				<a id="LoginButton" href="StudentHome.jsp"> Back</a>
			</div>
		</div>
	</div>

</body>

</html>