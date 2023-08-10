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
	// check adminAuth
	ArrayList<Course> allCourses = Course.viewAllCoursesList();
	%>
	
	<h1 class="header">Course List</h1>
	<div class="formContainer">
		<div class="list">
			<table class="displayTable">
				<tr>
					<th class="displayTableData">Course ID</th>
					<th class="displayTableData">Course Name</th>
					<th class="displayTableData">Course Fees</th>
					<th class="displayTableData">Duration</th>
				</tr>

				<%
				for (Course curCourse : allCourses) {
				%>
				<tr>
					<td class="displayTableData"><%=curCourse.getCourseID()%></td>
					<td class="displayTableData"><%=curCourse.getCourseName()%></td>
					<td class="displayTableData"><%=curCourse.getFee()%></td>
					<td class="displayTableData"><%=curCourse.getDurationInHrs()%></td>
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
