<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<h1>수정 확인</h1>

	<form method="post">
		<input type="hidden" name="noticeNo" value="${mId}" />
		게시물을 수정하시겠습니까? <br /> 
		<input type="submit" value="메시지 수정하기" />
	</form>
</body>
</html>