<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath}/admin/video/update" method="post" enctype="multipart/form-data">
	<label for="videoname">Video Name:</label> <br> 
	<input type="text" id="videoname" name="videoname" value="${vid.videoname}"><br> 
	
	<label for="thumbnail">Thumbnail Image:</label> <br> 
	<c:if test="${vid.thumbnail.substring(0,5) != 'https'}">
		<c:url value="/image?fname=${vid.thumbnail}" var="imgUrl"></c:url>
	</c:if> 
	<c:if test="${vid.thumbnail.substring(0,5) == 'https'}">
		<c:url value="${vid.thumbnail}" var="imgUrl"></c:url>
	</c:if> 
	<img height="150" width="200" src="${imgUrl}" />
	<input type="file" id="thumbnail" name="thumbnail"> <br> 
	
	<label for="status">Status:</label> <br> 
	<input type="text" id="status" name="status" value="${vid.status}"> <br> 
	
	<br> 
	<input type="submit" value="Submit">
</form>
