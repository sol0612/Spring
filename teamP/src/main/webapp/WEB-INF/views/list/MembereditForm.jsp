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
			<input type="hidden" name="userNo" value="${members.userNo}">
			아이디 : <input type="text" class="form-control" name="userId" value="${members.userId}"><br>
			이름 : <input type="text" class="form-control" name="userName" value="${members.userName}"><br>
			비밀번호 : <input type="text" class="form-control" name="userPassword"
				value="${members.userPassword}"><br>
			<br> 자기소개 :
			<textarea name="userIntro" class="form-control" cols="30" rows="5">${members.userIntro}</textarea>
			<br> <br> <input type="submit" class="btn btn-default" value="수정하기" /> <input
				type=button class="btn btn-default" value="취소" OnClick="javascript:history.back(-1)">
		</form>
	</div>
</body>
</html>