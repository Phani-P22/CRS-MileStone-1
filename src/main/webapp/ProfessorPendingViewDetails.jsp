<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.digit.javaTraining.CRS.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>

	<%
	session = request.getSession();
	Professor curProfessor = (Professor) session.getAttribute("curProfessor");
	if (curProfessor == null) {
		response.sendRedirect("index.html");
	}
	%>

	<h1>Your Details</h1>

	<div id="messageContainer" class="formContainer">
		<div class="list">
			<h2 class="message">
				Your Name:
				<%=curProfessor.getProfessorName()%>
			</h2>
			<h2 class="message">
				Your Age:
				<%=curProfessor.getAge()%></h2>
			<h2 class="message">
				Your City:
				<%=curProfessor.getCity()%></h2>
			<h2 class="message">
				Your CourseEnrolled ID:
				<%=curProfessor.getCourseID()%></h2>
			<h2 class="message">
				Your EmailID:
				<%=curProfessor.getEmailID()%></h2>
			<h2 class="message">
				Your YearsOfExperience:
				<%=curProfessor.getYearsOfExpreience()%></h2>
			<h2 class="message">
				Your PhoneNumber:
				<%=curProfessor.getPhoneNumber()%></h2>
		</div>
		<div class="buttonHolder">
			<a id="LoginButton" href="ProfessorPendingHome.jsp"> Back</a>
		</div>
	</div>
</body>


</html>