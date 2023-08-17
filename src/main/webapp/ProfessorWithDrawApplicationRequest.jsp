<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.digit.javaTraining.CRS.model.Professor"
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
	Professor curProfessor = (Professor) session.getAttribute("curProfessor");
	int courseID = curProfessor.getCourseID();

	Professor.deleteProfessorFromProfessorApplicationsTable(curProfessor);
	response.sendRedirect("index.html");
	// print all details of course
	%>

</body>
</html>