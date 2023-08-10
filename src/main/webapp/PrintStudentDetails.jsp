<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.Student"%>
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
	Student curStudent = (Student) session.getAttribute("curStudent");
	if (curStudent == null) {
		response.sendRedirect("index.html");
	}
	// print all details
	%>

<body>

	<h1>Current Student Request</h1>

	<div id="messageContainer" class="formContainer">
		<div class="list">
			<h2 class="message">
				Student Name:
				<%=curStudent.getStudentName()%>
			</h2>
			<h2 class="message">
				Student ID:
				<%=curStudent.getStudentID()%>
			</h2>
			<h2 class="message">
				Student Age:
				<%=curStudent.getAge()%></h2>
			<h2 class="message">
				Student City:
				<%=curStudent.getCity()%></h2>
			<h2 class="message">
				Student CourseEnrolled ID:
				<%=curStudent.getCourseEnrolled()%></h2>
			<h2 class="message">
				Student EmailID:
				<%=curStudent.getEmailID()%></h2>
			<h2 class="message">
				Student Gender:
				<%=curStudent.getGender()%></h2>
			<h2 class="message">
				Student PhoneNumber:
				<%=curStudent.getPhoneNumber()%></h2>
		</div>
		<div class="buttonHolder">
			<a id="LoginButton" href="StudentHome.jsp"> Back</a>
		</div>
	</div>
</body>


</html>