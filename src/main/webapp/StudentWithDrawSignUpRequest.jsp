<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.digit.javaTraining.CRS.model.*"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	session = request.getSession();
	Student curStudent = (Student) session.getAttribute("curStudent");
	int courseID = curStudent.getCourseEnrolled();
	
	Student.withDrawStudentSignUpRequest(curStudent);
	response.sendRedirect("index.html");
	// print all details of course
	%>

</body>
</html>