<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
  .form-group{
  	width:1200px;
  	margin: 0 auto;
  }
  label{
  	font-weight: 600px;
  	font-size: 18px;
  }
</style>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<h1>수정하기</h1>
	<br>
	<div class="form-group">
	<form method="post" enctype="multipart/form-data">
		<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
		작성자 : <input type="text" class="form-control" name="noticeWriter" value="${notice.noticeWriter}"><br>
		 제목 : <input type="text" class="form-control" name="noticeTitle" value="${notice.noticeTitle}"><br>
		<br> 내용 : <textarea name="noticeCont" class="form-control" cols="30">${notice.noticeCont}</textarea>
		<br> <br> 파일첨부 : <input type="file" class="form-control" name="noticeFile"><br>
		<br> <input type="submit" value="수정하기"  class="btn btn-default"/> <input type=button class="btn btn-default" value="취소" OnClick="javascript:history.back(-1)">
	</form>
	</div>
</body>
</html>