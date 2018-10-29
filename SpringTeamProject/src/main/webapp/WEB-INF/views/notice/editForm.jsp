<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<h1>수정하기</h1>
	<br>

	<form method="post" enctype="multipart/form-data">
		<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
		작성자 : <input type="text" name="noticeWriter" value="${notice.noticeWriter}"><br>
		 제목 : <input type="text" name="noticeTitle" value="${notice.noticeTitle}"><br>
		<br> 내용 : <textarea name="noticeCont" cols="30">${notice.noticeCont}</textarea>
		<br> <br> 파일첨부 : <input type="file" name="noticeFile"><br>
		<br> <input type="submit" value="수정하기" /> <input type=button value="취소" OnClick="javascript:history.back(-1)">
	</form>
</body>
</html>