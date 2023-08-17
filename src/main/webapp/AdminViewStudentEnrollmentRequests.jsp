<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.Student, java.util.ArrayList"%>
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
	int curIndex = (session.getAttribute("curIndex") != null) ? (int) session.getAttribute("curIndex") : 0;
	if (session.getAttribute("allRequests") == null) {
		ArrayList<Student> allRequests = Student.getAllStudentRequestsList();
		session.setAttribute("allRequests", allRequests);
	}
	ArrayList<Student> allRequests = (ArrayList<Student>) session.getAttribute("allRequests");

	if (curIndex >= allRequests.size()) {
		// print all are reviewed!
		session.removeAttribute("curIndex");
		session.removeAttribute("allRequests");
		response.sendRedirect("/CRS/AllRequestsReviewed.html");
		return;
	}
	Student curStudent = allRequests.get(curIndex);

	curIndex++;
	session.setAttribute("curIndex", curIndex);
	%>


	<h1>Current Professor Request</h1><br>

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

		<br>
		<br>
		<h3>Manage Request</h3>
		<form action="manageStudentSignUpReq" method="post">
			<select id="operation" name="operation">
				<option value="Approve">Approve Request</option>
				<option value="Reject">Reject Request</option>
				<option value="Skip">Skip Request</option>
			</select> <br>
			<br> <input type="submit" class="LoginButton">
		</form>
	</div>

</body>
</html>