<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
<link rel="stylesheet" href="../css/default.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.form-group {
	width: 1200px;
	margin: 0 auto;
}

label {
	font-weight: 600px;
	font-size: 18px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<h1 style="text-align: center;">수정하기</h1>
	<br>
	<div class="form-group">
		<form method="post">
			<input type="hidden" name="commentNo" value="${comment.commentNo}">
			게시글번호 : <input type="text" class="form-control" name="boardNo"
				value="${comment.boardNo}"><br> 게시자번호 : <input
				type="text" class="form-control" name="userId"
				value="${comment.userId}"><br> 내용 : <input type="text"
				class="form-control" name="commentCont"
				value="${comment.commentCont}"><br>
			<br> <br> <input type="submit" class="btn btn-default"
				value="수정하기" /> <input type=button class="btn btn-default"
				value="취소" OnClick="javascript:history.back(-1)">
		</form>
	</div>
</body>
</html>