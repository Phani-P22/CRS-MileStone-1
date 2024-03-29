<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.digit.javaTraining.CRS.model.*, java.util.ArrayList"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student SignUp</title>
<link rel="stylesheet" href="style.css">
<%
ArrayList<Course> allCourses = Course.viewAllCoursesList();
%>
</head>

<body>
	<h1 class="header">Add Student</h1>
	<div class="formContainer">
		<div class="list">
			<div id="inputForm">
				<form action="studentSignUp" method="post">
					<table>
						<tr>
							<td><label class="label">UserName</label></td>
							<td><input class="input" type="text" name="userName"
								placeholder="" required></td>
						</tr>
						<tr>
							<td><label class="label">Password</label></td>
							<td><input class="input" type="text" name="password"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Re-Enter Password</label></td>
							<td><input class="input" type="text"
								name="reEnteredPassword" placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Your Name</label></td>
							<td><input class="input" type="text" name="name"
								placeholder="" required></td>
						</tr>
						<tr>
							<td><label class="label">Your Age</label></td>
							<td><input class="input" type="number" name="age"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Your City</label></td>
							<td><input class="input" type="text" name="city"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Course ID</label></td>
							<td><select name="courseID" id="operation">
									<%
									for (Course curCourse : allCourses) {
									%>
									<option value="<%=curCourse.getCourseID()%>"><%=curCourse.getCourseID()%>
										-
										<%=curCourse.getCourseName()%></option>
									<%
									}
									%>
							</select></td>
						</tr>
						<tr>
							<td><label class="label">Gender</label></td>
							<td><input class="input" type="text" name="gender"
								placeholder="" required></td>
						</tr>
						<tr>
							<td><label class="label">Your Email ID</label></td>
							<td><input class="input" type="text" name="emailID"
								placeholder=""></td>
						</tr>
						<tr>
							<td><label class="label">Your Phone Number</label></td>
							<td><input class="input" type="text" name="phoneNumber"
								placeholder="" required></td>
						</tr>
					</table>
					<div class="buttonHolder">
						<input id="LoginButton" class="input" type="submit">
					</div>
				</form>
			</div>
			<p>
				<td><a href="StudentLogin.html" id="loginsingup">Have
						Account? Click Here to LogIn!</a></td>
			</p>
		</div>
	</div>
</body>
</html>