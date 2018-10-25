<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style type="text/css">
#write {
	width: 100px;
	height: 20px;
	text-align: center;
	background-color: pink;
	margin: 20px;
}

#wrap li {
	border: 1px solid #EEEEEE;
	text-align: center;
	width: 200px;
	height: 30%;
}

#title {
	margin-left: 50px;
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<div id="write">
		<a href="write">방명록남기기</a>
	</div>


	<c:if test="${viewData.isEmpty()}">
	작성된 방명록 메세지가 없습니다.
	</c:if>

	<c:if test="${!viewData.isEmpty()}">
		<div id="wrap">
			<h1 id="title">방명록</h1>
			<ul>
				<c:forEach var="message" items="${viewData.messageList}">
					<li>${message.id}<br> ${message.guestId} <br>
						${message.guestName} <br> ${message.getMessage()} <br> 
						<c:if test="${loginInfo.userId eq message.guestId}">
							<a href="delete?id=${message.id}">[삭제하기]</a>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>

		<!-- 해당페이지로 가게 넘버링 해주기 -->
		<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
			<a href="list?page=${num}">[${num}]</a>
		</c:forEach>
	</c:if>

</body>
</html>