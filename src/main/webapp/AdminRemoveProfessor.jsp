<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1 class="header">Remove Professor</h1>
	<div class="formContainer">
		<form action="removeProfessor" method="post">
			<table>
				<tr>
					<td><label class="label">Professor ID</label></td>
					<td><input class="input" type="text" name="professorID"
						placeholder=""></td>
				</tr>
			</table>
			<div class="buttonHolder">
				<input id="LoginButton" type="submit" value="Remove">
			</div>
		</form>
	</div>
</body>

</html>