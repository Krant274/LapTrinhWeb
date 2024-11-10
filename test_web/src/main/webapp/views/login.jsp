<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<form action="/test_web/login" method="post">

	<c:if test="${alert !=null}">
		<h3 class="alert alert-danger">${alert}</h3>
	</c:if>
	<div class="container">
		<label for="uname"><b>Username</b></label> <input type="text"
			placeholder="Enter Username" name="uname" required> <label
			for="psw"><b>Password</b></label> <input type="password"
			placeholder="Enter Password" name="psw" required>

		<button type="submit">Login</button>
		<label> <input type="checkbox" checked="checked"
			name="remember"> Remember me
		</label>
	</div>

	<div class="container" style="background-color: #f1f1f1">
		<button type="button" class="cancelbtn">Cancel</button>
		<span class="psw">Forgot <a href="#">password?</a></span>
	</div>
</form>

</html>