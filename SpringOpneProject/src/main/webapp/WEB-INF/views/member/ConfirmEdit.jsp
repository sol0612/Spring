<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
h2, td {
	padding: 10px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<h1>수정 확인</h1>

	<form method="post">
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td><input type="text" name="userId" value="${mId}" readonly /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="password" value="${mPw}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" value="${mName}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="정보 수정하기" /></td>
			</tr>
		</table>
	</form>

</body>
</html>