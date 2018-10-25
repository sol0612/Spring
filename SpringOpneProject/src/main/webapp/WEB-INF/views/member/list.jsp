<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
td {
	text-align: center;
	width: 100px;
	height: 100px;
}

img {
	height: 100px;
}

h1 {
	padding: 10px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<h1>회원리스트</h1>

	<table border="1">
		<tr>
			<th>사진</th>
			<th>ID</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>관리</th>
		</tr>
		<c:if test="${members != null}">
			<c:forEach var="i" items="${members}">
				<tr>
					<c:choose>
						<c:when test="${i.userPhoto != null}">
							<td><img
								src="${pageContext.request.contextPath}/uploadfile/userphoto/${i.userPhoto}"></td>
						</c:when>
						<c:otherwise>
							<td><img
								src="${pageContext.request.contextPath}/uploadfile/userphoto/no_img.png"></td>
						</c:otherwise>
					</c:choose>
					<td>${i.userId}</td>
					<td>${i.userName}</td>
					<td>${i.password}</td>
					<td>
					<c:if test="${loginInfo.userId eq i.userId}">
							<a href="${pageContext.request.contextPath}/member/delete">삭제</a>
						</c:if></td>

				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>