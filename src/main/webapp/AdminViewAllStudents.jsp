<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.*, java.util.ArrayList"%>
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
	// check adminAuth
	ArrayList<Student> allStudents = Student.getAllStudentsList();
	%>

	<h1 class="header">Students List</h1>

	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Student Name</th>
					<th class="displayTableData">Student ID</th>
					<th class="displayTableData">Age</th>
					<th class="displayTableData">City</th>
					<th class="displayTableData">Course ID</th>
					<th class="displayTableData">Gender</th>
					<th class="displayTableData">Marks</th>
				</tr>

				<%
				for (Student curStudent : allStudents) {
				%>
				<tr>
					<td class="displayTableData"><%=curStudent.getStudentName()%></td>
					<td class="displayTableData"><%=curStudent.getStudentID()%></td>
					<td class="displayTableData"><%=curStudent.getAge()%></td>
					<td class="displayTableData"><%=curStudent.getCity()%></td>
					<td class="displayTableData"><%=curStudent.getCourseEnrolled()%></td>
					<td class="displayTableData"><%=curStudent.getGender()%></td>
					<td class="displayTableData"><%=curStudent.getMarksSecured()%></td>
				</tr>
				<%
				}
				%>
			</table>
			<div class="buttonHolder">
				<a id="LoginButton" href="AdminHome.jsp">Back</a>
			</div>
		</div>
	</div>
</body>

</html>