<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항작성</title>
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


	<h1 style="text-align: center;">공지사항 쓰기</h1>
	<br>
	<div class="form-group">
		<form method="post" enctype="multipart/form-data">
			<label>제목 </label><input type="text" name="noticeTitle"
				class="form-control" placeholder="제목을 입력하세요."><br>
			<br> <label>작성자 </label><input type="text" name="noticeWriter"
				value="manager" class="form-control"><br>
			<br> <label>내용</label>
			<textarea name="noticeCont" cols="30" class="form-control"
				placeholder="내용을 입력하세요."></textarea>
			<br>
			<br> <label>파일첨부</label><input type="file" name="noticeFile"
				class="form-control"> <br>
			<br> <input type="submit" value="글등록" class="btn btn-default" />
			<input type=button value="취소" class="btn btn-default"
				OnClick="javascript:history.back(-1)">
		</form>
	</div>
</body>
</html>