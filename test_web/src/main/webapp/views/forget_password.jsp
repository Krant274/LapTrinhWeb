<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<form action="/test_web/forgetpwd" method="post">

	<c:if test="${alert !=null}">
		<h3 class="alert alert-danger">${alert}</h3>
	</c:if>
	<div class="container">
		<label for="uname"><b>Username</b></label> <input type="text"
			placeholder="Enter Username" name="uname" required> <label
			for="psw"><b>Password</b></label> <input type="password"
			placeholder="Enter Password" name="psw" required>

		<button type="submit">Change Password</button>
	</div>
</form>

</html>