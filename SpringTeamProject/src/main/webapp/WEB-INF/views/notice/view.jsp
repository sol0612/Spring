<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
td {
	width: 200px;
	text-align: center;
}

#title {
	margin-left: 20px;
	margin-bottom: 10px;
}

img {
	width: 300px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<h1 id="title">게시글 보기</h1>
	<div>
		<form method="get" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<c:set var="i" value="${viewData}" />
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성날짜</th>
				</tr>
				<tr>
					<td>${i.noticeNo}</td>
					<td>${i.noticeTitle}</td>
					<td>${i.noticeWriter}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${i.noticeDate}" /></td>
				</tr>
				<tr>
					<td colspan="4"><c:set var="img" value="${i.noticePhoto}" />
						<c:if test="${img != null}">
							<br>
							<img src="${pageContext.request.contextPath}/uploadfile/${i.noticePhoto}">
							<br>
						</c:if> ${i.noticeCont}</td>
				</tr>
					<c:if test="${!i.noticeWriter.isEmpty()}">
				<tr>
						<td colspan="4" style="text-align: right"><a
							href="edit?noticeNo=${i.noticeNo}">수정하기</a> <a
							href="delete?noticeNo=${i.noticeNo}">삭제하기</a> <a
							href="report?noticeNo=${i.noticeNo}">신고하기</a></td>
				</tr>
					</c:if>
				<tr>
					<td colspan="4" style="text-align: rigth"><a href="list">목록보기</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>