<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.Professor, com.digit.javaTraining.CRS.model.CourseChangeResponse, java.util.ArrayList"%>
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
	if (session.getAttribute("allPCCRequests") == null) {
		ArrayList<CourseChangeResponse> allRequests = Professor.getAllCourseChangeReqOfProfessors();
		session.setAttribute("allPCCRequests", allRequests);
	}
	ArrayList<CourseChangeResponse> allRequests = (ArrayList<CourseChangeResponse>) session.getAttribute("allPCCRequests");

	if (curIndex >= allRequests.size()) {
		// print all are reviewed!
		session.removeAttribute("curIndex");
		session.removeAttribute("allPCCRequests");
		response.sendRedirect("/CRS/AllRequestsReviewed.html");
		return;
	}
	CourseChangeResponse curCourseChangeRequest = allRequests.get(curIndex);
	Professor curProfessor = (Professor) curCourseChangeRequest.getCurObject();
	int newCourseID = curCourseChangeRequest.getNewCourseID();

	curIndex++;
	session.setAttribute("curIndex", curIndex);
	%>

	<h1>Current Professor Request</h1>

	<div id="messageContainer" class="formContainer">
		<div class="list">
			<h2 class="message">
				Professor Name:
				<%=curProfessor.getProfessorName()%>
			</h2>
			<h2 class="message">
				Professor ID:
				<%=curProfessor.getProfessorID()%>
			</h2>
			<h2 class="message">
				Professor Age:
				<%=curProfessor.getAge()%></h2>
			<h2 class="message">
				Professor City:
				<%=curProfessor.getCity()%></h2>
			<h2 class="message">
				Professor Teaching CourseID:
				<%=curProfessor.getCourseID()%></h2>
			<h2 class="message">
				Professor EmailID:
				<%=curProfessor.getEmailID()%></h2>
			<h2 class="message">
				Professor Years Of Experience:
				<%=curProfessor.getYearsOfExpreience()%></h2>
			<h2 class="message">
				Professor PhoneNumber:
				<%=curProfessor.getPhoneNumber()%></h2>
		</div>

		<h2>
			Wants to Change to
			<%=newCourseID%></h2>

		<h3>Manage Request</h3>
		<form action="manageProfessorCourseChangeReq" method="post">
			<select id="operation" name="operation">
				<option value="Approve">Approve Request</option>
				<option value="Reject">Reject Request</option>
				<option value="Skip">Skip Request</option>
			</select> <input type="submit">
		</form>
	</div>
</body>
</html>