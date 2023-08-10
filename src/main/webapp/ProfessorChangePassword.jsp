<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>

<body>
	<h1 class="header">Change Password</h1>
	<div class="formContainer">
		<form id="form" action="changePasswordProfessor" method="post">
			<div class="list">
				<table>
					<tr>
						<td><label class="label" for="pass"> Old Password </label></td>
						<td><input class="input" type="password" name="oldPassword">
						</td>
					</tr>
					<tr>
						<td><label class="label" for="pass1"> New Password </label></td>
						<td><input class="input" type="password" name="newPassword">
						</td>
					</tr>
					<tr>
						<td><label class="label" for="pass2"> Confirm
								Password</label></td>
						<td><input class="input" type="password"
							name="reEnterNewPassword"></td>
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