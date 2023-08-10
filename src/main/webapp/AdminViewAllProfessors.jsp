<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>View All Professor</title>
</head>
<body>
	<%
	session = request.getSession();
	// check adminAuth
	ArrayList<Professor> allProfessors = Professor.getAllProfessorsList();
	%>
	<h1 class="header">Professor List</h1>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">ID</th>
					<th class="displayTableData">Name</th>
					<th class="displayTableData">Age</th>
					<th class="displayTableData">Experience</th>
					<th class="displayTableData">Email ID</th>
					<th class="displayTableData">Course ID</th>
				</tr>

				<%
				for (Professor curProfessor : allProfessors) {
				%>
				<tr>
					<td class="displayTableData"><%=curProfessor.getProfessorID()%></td>
					<td class="displayTableData"><%=curProfessor.getProfessorName()%></td>
					<td class="displayTableData"><%=curProfessor.getAge()%></td>
					<td class="displayTableData"><%=curProfessor.getYearsOfExpreience()%></td>
					<td class="displayTableData"><%=curProfessor.getEmailID()%></td>
					<td class="displayTableData"><%=curProfessor.getCourseID()%></td>
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
