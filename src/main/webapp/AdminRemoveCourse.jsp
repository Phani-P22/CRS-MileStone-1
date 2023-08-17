<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css">
	<meta charset="ISO-8859-1">
	<title>Delete Course</title>
</head>

<body>
	<h1 class="header">Delete Course</h1>
	<div class="formContainer">
		<form action="removeCourse" method="post">
			<table>
				<tr>
					<td>
						<label class="label">Course ID</label>
					</td>
					<td>
						<input class="input" type="number" name="courseID" placeholder="">
					</td>
				</tr>
			</table>
			<div class="buttonHolder">
				<input id="LoginButton" type="submit" value="Delete">
			</div>
		</form>
	</div>
</body>

</html>