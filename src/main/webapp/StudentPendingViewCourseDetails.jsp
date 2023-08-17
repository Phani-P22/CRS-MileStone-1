<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.digit.javaTraining.CRS.model.*"%>
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
	int courseID = curStudent.getCourseEnrolled();

	Course curCourse = Course.getCourseFromCourseTableUsingID(courseID);
	if (curCourse == null) {
		session.setAttribute("title", "View Enrolled Course");
		session.setAttribute("message", "Course is DeRegistered. Raise request to Admin!");
		session.setAttribute("redirectLink", "StudentHome.jsp");
		response.sendRedirect("AppPrintMessage.jsp");
		return;
	}
	%>

<body>

	<h1>Enrolled Course Details</h1>

	<div id="messageContainer" class="formContainer">
		<div class="list">
			<h2 class="message">
				Course ID:
				<%=curCourse.getCourseID()%>
			</h2>
			<h2 class="message">
				Course Name:
				<%=curCourse.getCourseName()%>
			</h2>
			<h2 class="message">
				Description:
				<%=curCourse.getDescription()%></h2>
			<h2 class="message">
				Duration In Hours:
				<%=curCourse.getDurationInHrs()%></h2>
			<h2 class="message">
				Fee:
				<%=curCourse.getFee()%></h2>
		</div>
		<div class="buttonHolder">
			<a id="LoginButton" href="StudentPendingHome.jsp"> Back</a>
		</div>
	</div>
</body>
</html>