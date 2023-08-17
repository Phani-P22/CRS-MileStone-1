<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.CRS.model.Professor, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%
	session = request.getSession();
	int curIndex = (session.getAttribute("curIndex") != null) ? (int) session.getAttribute("curIndex") : 0;
	if (session.getAttribute("allPARRequests") == null) {
		ArrayList<Professor> allRequests = Professor.getAllProfessorApplicationsList();
		session.setAttribute("allPARRequests", allRequests);
	}
	ArrayList<Professor> allRequests = (ArrayList<Professor>) session.getAttribute("allPARRequests");

	if (curIndex >= allRequests.size()) {
		// print all are reviewed!
		session.removeAttribute("curIndex");
		session.removeAttribute("allPARRequests");
		response.sendRedirect("/CRS/AllRequestsReviewed.html");
		return;
	}
	Professor curProfessor = allRequests.get(curIndex);

	curIndex++;
	session.setAttribute("curIndex", curIndex);
	%>

	<h1>Current Professor Request</h1>

	<div id="messageContainer" class="formContainer">
		<div class="list">
			<h2 class="message">
				Professor Name:
				<%=curProfessor.getProfessorName()%></h2>
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

		<h3>Manage Request</h3>
		<form action="manageProfessorApplicationReq" method="post">
			<select id="operation" name="operation">
				<option value="Approve">Approve Request</option>
				<option value="Reject">Reject Request</option>
				<option value="Skip">Skip Request</option>
			</select><br><br>
			<input id="LoginButton" type="submit">
		</form>
	</div>

</body>
</html>