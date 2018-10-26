<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<h1>공지사항 쓰기</h1><br>
	
	<form method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="noticeTitle"><br><br>
		작성자 : <input type="text" name="noticeWriter" value="manager"><br><br>
		내용 : <textarea name="noticeCont" cols="30"></textarea> <br><br> 
		파일첨부 : <input type="file" name="noticeFile"> <br><br>
		<input type="submit" value="글등록" /> <input type=button value="취소" OnClick="javascript:history.back(-1)">
	</form>
</body>
</html>