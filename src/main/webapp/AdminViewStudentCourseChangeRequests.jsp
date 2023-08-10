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
	int curIndex = (session.getAttribute("curIndex") != null) ? (int) session.getAttribute("curIndex") : 0;
	if (session.getAttribute("allSCCRequests") == null) {
		ArrayList<CourseChangeResponse> allRequests = Student.getAllCourseChangeReqOfStudents();
		session.setAttribute("allSCCRequests", allRequests);
	}
	ArrayList<CourseChangeResponse> allRequests = (ArrayList<CourseChangeResponse>) session.getAttribute("allSCCRequests");

	if (curIndex >= allRequests.size()) {
		// print all are reviewed!
		session.removeAttribute("curIndex");
		session.removeAttribute("allSCCRequests");
		response.sendRedirect("/CRS/AllRequestsReviewed.html");
		return;
	}
	CourseChangeResponse curCourseChangeRequest = allRequests.get(curIndex);
	Student curStudent = (Student) curCourseChangeRequest.getCurObject();
	int newCourseID = curCourseChangeRequest.getNewCourseID();

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

		<h2>
			Wants to Change to
			<%=newCourseID%></h2>

		<h3>Manage Request</h3>
		<form action="manageStudentCourseChangeReq" method="post">
			<select id="operation" name="operation">
				<option value="Approve">Approve Request</option>
				<option value="Reject">Reject Request</option>
				<option value="Skip">Skip Request</option>
			</select> <input type="submit">
		</form>
	</div>
</body>
</html>