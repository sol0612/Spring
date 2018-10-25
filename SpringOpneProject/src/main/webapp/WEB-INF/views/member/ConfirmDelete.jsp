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


	<h1>삭제 확인</h1>

	<form method="post">
		<input type="hidden" name="userId" value="${mId}" />
		회원정보를 삭제하시겠습니까? <br /> 
		<input type="submit" value="정보 삭제하기" />
	</form>
</body>
</html>