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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
#title {
	margin-left: 20px;
	margin-bottom: 10px;
}

td, th{
	width: 200px;
	height: 30px;
}

a {
	text-decoration: none;
}

#paging {
	width: 300px;
	margin: 0 auto;
}

#wrap {
	width: 1500px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>
<br><br><br><br>
	<c:if test="${viewData.isEmpty()}">
		<h1 id="title">
			작성된 공지사항이 없습니다. <br> <a href="write">글쓰기</a>
		</h1>
	</c:if>

	<c:if test="${!viewData.isEmpty()}">
		<div id="wrap">
			<h1 id="title" style="text-align: center;">공지사항</h1>

			<form>
				<table class="table table-hover">
					<tr>
						<th>게시글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
					<c:forEach var="notice" items="${viewData.noticeList}">
						<tr>
							<td>${notice.noticeNo}</td>
							<td><a href="view?noticeNo=${notice.noticeNo}">${notice.noticeTitle}</a></td>
							<td>${notice.noticeWriter}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${notice.noticeDate}" /></td>
							<td>${notice.noticeHit}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" style="text-align: right;"><a href="write">글쓰기</a></td>
					</tr>
				</table>
			</form>
		</div>

		<!-- 해당페이지로 가게 넘버링 해주기 -->
		<div id="paging">
			<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
				<a href="list?page=${num}">[${num}]</a>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>