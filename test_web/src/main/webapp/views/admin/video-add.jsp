<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="${pageContext.request.contextPath}/admin/video/insert" method="post" enctype="multipart/form-data">
	<label for="videoname">Video Name:</label> <br> 
	<input type="text" id="videoname" name="videoname"><br> 
	
	<label for="videofile">Upload Video:</label> <br> 
	<input type="file" id="videofile" name="videofile"> <br> 
	
	<label for="thumbnail">Thumbnail Image:</label> <br> 
	<input type="file" id="thumbnail" name="thumbnail"> <br> 
	
	<label for="status">Status:</label> <br> 
	<input type="text" id="status" name="status"> <br> 
	
	<br> 
	<input type="submit" value="Submit">
</form>
