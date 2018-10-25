<%@page import="com.bitcamp.op.member.model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1 class="title">OpenProject</h1>

<ul id="gnb">
	<li><a href="${pageContext.request.contextPath}/">메인</a></li>
	<li><a href="${pageContext.request.contextPath}/member/memberReg">회원가입</a></li>
	<%
		MemberInfo loginInfo = (MemberInfo) request.getSession(false).getAttribute("loginInfo");

		if (loginInfo == null) {
	%>
	<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
	<%
		} else {
	%>
	<li><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
	<%
		}
	%>
	<li><a href="${pageContext.request.contextPath}/member/mypage">마이페이지</a></li>
	<li><a href="${pageContext.request.contextPath}/member/list">회원
			리스트</a></li>
	<%
		if (loginInfo != null) {
	%>
	<li><a href="${pageContext.request.contextPath}/guest/list">방명록</a>
	<li>
		<%
			}
		%>
	
</ul>
