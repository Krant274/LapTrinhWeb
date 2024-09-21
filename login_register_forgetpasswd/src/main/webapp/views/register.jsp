<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.register-container {
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

input[type=text], input[type=password], input[type=email], input[type=tel],
	input[type=file] {
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

	<div class="register-container">
		<h2>Register</h2>

		<form action="register" method="post">
			<label for="email">Email:</label> <input type="email" id="email"
				name="email" placeholder="Enter your email" required> <label
				for="username">Username:</label> <input type="text" id="username"
				name="username" placeholder="Choose a username" required> <label
				for="fullname">Full Name:</label> <input type="text" id="fullname"
				name="fullname" placeholder="Enter your full name" required>

			<label for="passnord">Password:</label> <input type="password"
				id="password" name="password" placeholder="Enter your password"
				required> <label for="avatar">Avatar:</label> <input
				type="text" id="avatar" name="avatar" placeholder="Image:" required>

			<label for="phone">Phone:</label> <input type="tel" id="phone"
				name="phone" placeholder="Enter your phone number" required>

			<input type="submit" value="Register">
		</form>

		<%
		// Error message handling
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
