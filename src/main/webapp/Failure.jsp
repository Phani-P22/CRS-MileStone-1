<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
session = request.getSession();
String title = (String) session.getAttribute("title");
String message = (String) session.getAttribute("message");
String redirectLink = (String) session.getAttribute("redirectLink");

session.removeAttribute("title");
session.removeAttribute("message");
session.removeAttribute("redirectLink");
%>
<title><%=title%></title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<br>
	<br>
	<br>
	<div class="formContainer">
		<h1><%=message%></h1>
		<br> <a href="<%=redirectLink%>">Click Here to Redirect</a>
	</div>
</body>
</html>