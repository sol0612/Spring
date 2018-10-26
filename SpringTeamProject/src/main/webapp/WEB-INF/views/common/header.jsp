<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1 class="title">관리자페이지</h1>

<ul id="gnb">
	<li><a href="${pageContext.request.contextPath}/">회원관리</a></li>
	<li><a href="${pageContext.request.contextPath}/member/memberReg">게시글관리</a></li>
	<li><a href="${pageContext.request.contextPath}/member/login">댓글관리</a></li>
	<li><a href="${pageContext.request.contextPath}/member/mypage">신고접수된내역</a></li>
	<li><a href="${pageContext.request.contextPath}/notice/list">공지사항</a></li>
</ul>
