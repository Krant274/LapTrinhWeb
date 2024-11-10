<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<a href="${pageContext.request.contextPath}/admin/video/add">Add Video</a>

<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Thumbnail</th>
		<th>VideoID</th>
		<th>VideoName</th>
		<th>Status</th>
		<th>Action</th>
	</tr>

	<c:forEach items="${listvid}" var="vid" varStatus="STT">
		<tr>
			<td>${STT.index + 1}</td>
			
			<!-- Display thumbnail or placeholder if none -->
			<td>
				<c:choose>
					<c:when test="${vid.videoname != null && !vid.videoname.startsWith('https')}">
						<c:url value="/videos/${vid.videoname}" var="videoUrl"></c:url>
					</c:when>
					<c:otherwise>
						<c:url value="${vid.videoname}" var="videoUrl"></c:url>
					</c:otherwise>
				</c:choose>
				<img height="150" width="200" src="${videoUrl}" alt="Video Thumbnail" />
			</td>

			<td>${vid.videoid}</td>
			<td>${vid.videoname}</td>
			<td><span>${vid.status == 1 ? 'Active' : 'Inactive'}</span></td>
			
			<td>
				<a href="<c:url value='/admin/video/edit?id=${vid.videoid}'/>">Edit</a> |
				<a href="<c:url value='/admin/video/delete?id=${vid.videoid}'/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
