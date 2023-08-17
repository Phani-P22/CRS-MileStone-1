<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Change UserName</title>
</head>

<body>
	<h1 class="header">Change UserName</h1>
	<div class="formContainer">
		<form id="form" action="changeUserNameProfessor" method="post">
			<div class="list">
				<table>
					<tr>
						<td><label class="label" for="pass"> Old UserName </label></td>
						<td><input class="input" type="password" name="oldUserName">
						</td>
					</tr>
					<tr>
						<td><label class="label" for="pass1"> New UserName </label></td>
						<td><input class="input" type="password" name="newUserName">
						</td>
					</tr>
					<tr>
						<td><label class="label" for="pass2"> Enter Password </label></td>
						<td><input class="input" type="password" name="password">
						</td>
					</tr>
				</table>
				<div class="buttonHolder">
					<input class="input" id="LoginButton" type="submit"
						value="Change Password">
				</div>
			</div>
		</form>
	</div>
</body>
</html>