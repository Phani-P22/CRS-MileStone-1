<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	session = request.getSession();
	Professor curProfessor = (Professor) session.getAttribute("curProfessor");
	ArrayList<Student> allStudents = Professor.getAllStudentsUnderProfessor(curProfessor);
	%>

	<h1 class="header">Course List</h1>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Student Name</th>
					<th class="displayTableData">Student ID</th>
					<th class="displayTableData">Age</th>
					<th class="displayTableData">City</th>
					<th class="displayTableData">Course ID</th>
					<th class="displayTableData">Email</th>
					<th class="displayTableData">Gender</th>
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
					<td class="displayTableData"><%=curStudent.getEmailID()%></td>
					<td class="displayTableData"><%=curStudent.getGender()%></td>
				</tr>

				<%
				}
				%>
			</table>
			<div class="buttonHolder">
				<a id="LoginButton" href="ProfessorHome.jsp">Back</a>
			</div>
		</div>
	</div>
</body>
</html>
