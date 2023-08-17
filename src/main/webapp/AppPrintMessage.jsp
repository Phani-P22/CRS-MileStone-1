<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%
session = request.getSession();
String title = (String) session.getAttribute("title");
String message = (String) session.getAttribute("message");
String redirectLink = (String) session.getAttribute("redirectLink");
%>

<head>
<meta charset="ISO-8859-1">
<title><%=title%></title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<br>
	<br>
	<br>
	<div id="messageContainer" class="formContainer">
		<div class="list">
			<h2 class="message"><%=message%></h2>
		</div>
		<div class="buttonHolder">
			<a class="LinkButton" href=<%=redirectLink%>>Back</a>
		</div>
	</div>
</body>
</html>

