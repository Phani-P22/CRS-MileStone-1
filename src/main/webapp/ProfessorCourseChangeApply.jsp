<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" href="style.css">

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


			<form id="form" action="changeCourseEnrollmentProfessor"
				method="post">
				<div class="list">
					<br>
					<table>
						<tr>
							<td><label class="label" for="pass">Select Course To
									Change To</label></td>
							<td><input class="input" type="password" name="newCourseID">
							</td>
						</tr>
					</table>
					<div class="buttonHolder">
						<input class="input" id="LoginButton" type="submit"
							value="Raise Request">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
