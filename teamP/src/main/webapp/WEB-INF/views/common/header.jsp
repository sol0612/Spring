<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header active">
				<a href="<c:url value='/notice/list' />"><img
					src="${pageContext.request.contextPath}/uploadfile/logo2.png"
					style="height: 50px;"></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/list/memberList' />">회원관리</a></li>
				<li><a href="<c:url value='/list/boardList' />">게시글관리</a></li>
				<li><a href="<c:url value='/list/commentList' />">댓글관리</a></li>
				<li><a href="<c:url value='/notice/list' />">공지사항</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>