<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.*, java.util.ArrayList"%>
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

	int curIndex = (session.getAttribute("curIndex") != null) ? (int) session.getAttribute("curIndex") : 0;
	if (session.getAttribute("allStudentsUnderProfessor") == null) {
		ArrayList<Student> allStudentsUnderProfessor = Professor.getAllUnGradedStudentsUnderProfessor(curProfessor);
		session.setAttribute("allStudentsUnderProfessor", allStudentsUnderProfessor);
	}
	ArrayList<Student> allStudentsUnderProfessor = (ArrayList<Student>) session.getAttribute("allStudentsUnderProfessor");

	if (curIndex >= allStudentsUnderProfessor.size()) {
		// print all are reviewed!
		session.removeAttribute("curIndex");
		session.removeAttribute("allStudentsUnderProfessor");
		response.sendRedirect("/CRS/ProfessorHome.jsp");
		return;
	}

	Student curStudent = allStudentsUnderProfessor.get(curIndex);

	curIndex++;
	session.setAttribute("curIndex", curIndex);
	%>


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

		<h3>Manage Request</h3>
		<form action="gradeStudents" method="post">

			<label>Enter Marks: </label><input type="number" name="marksGiven">
			<input type="submit">

		</form><br>
		<a href="ProfessorGradeStudents.jsp">Skip</a>


	</div>
</body>
</html>