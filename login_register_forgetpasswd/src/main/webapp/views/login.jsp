<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.login-container {
	width: 300px;
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

.forgot-password {
	text-align: center;
	margin-top: 20px;
}

.forgot-password a {
	color: #007BFF;
	text-decoration: none;
}

.forgot-password a:hover {
	text-decoration: underline;
}

.error {
	color: red;
	text-align: center;
}
</style>
</head>
<body>

	<jsp:include page="/topbar.jsp" />

	<div class="login-container">
		<h2>Login</h2>

		<form action="login" method="post">
			<label for="username">Username:</label> <input type="text"
				id="username" name="username" placeholder="Enter Username" required>

			<label for="password">Password:</label> <input type="password"
				id="password" name="password" placeholder="Enter Password" required>

			<label> <input type="checkbox" name="remember">
				Remember Me
			</label> <input type="submit" value="Login">
		</form>

		<div class="forgot-password">
			<a href="<%=request.getContextPath()%>/reset_passwd">Forgot
				Password?</a>
		</div>

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
