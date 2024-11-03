<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.reset-password-container {
	width: 400px;
	margin: 100px auto;
	padding: 50px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 10px;
	margin: 10px 0 20px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type=submit] {
	width: 100%;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.error {
	color: red;
	text-align: center;
}
</style>
</head>
<body>

	<jsp:include page="/topbar.jsp" />

	<div class="reset-password-container">
		<h2>Reset Password</h2>

		<form action="reset_passwd" method="post">
			<label for="username">Username:</label> <input type="text"
				id="username" name="username" placeholder="Enter your username"
				required> <label for="new_password">New Password:</label> <input
				type="password" id="new_password" name="new_password"
				placeholder="Enter new password" required> <label
				for="confirm_password">Confirm Password:</label> <input
				type="password" id="confirm_password" name="confirm_password"
				placeholder="Confirm your password" required> <input
				type="submit" value="Reset Password">
		</form>

		<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null) {
		%>
		<div class="error"><%=errorMessage%></div>
		<%
		}
		%>
	</div>

</body>
</html>
