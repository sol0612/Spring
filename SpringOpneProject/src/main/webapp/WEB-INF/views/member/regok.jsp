<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
<link rel="stylesheet" href="../css/default.css">
<style>
h2, td {
	padding: 10px;
}

#memherPhoto {
	background-image:
		url('${pageContext.request.contextPath}/uploadfile/userphoto/${memberInfo.userPhoto}');
	background-size: 100%;
	width: 150px;
	height: 150px;
	border: 1px solid #333333;
	border-radius: 75px;
	margin: 20px 0;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<h2>회원가입정보</h2>

	<div id="memherPhoto"></div>

	<table>
		<tr>
			<td>아이디(이메일)</td>
			<td>${memberInfo.userId}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${memberInfo.password}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${memberInfo.userName}</td>
		</tr>
	</table>

</body>
</html>