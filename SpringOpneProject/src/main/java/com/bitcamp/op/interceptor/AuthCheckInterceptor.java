package com.bitcamp.op.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 세션에 로그인 정보 유무 확인 -> return true : 정상적인 컨트롤러 실행
		HttpSession session = request.getSession(false);

		if (session != null) {

			// 로그인상태라면 로그인인포가 있을것임!
			Object obj = session.getAttribute("loginInfo");

			if (obj != null) {

				return true;

			}
		}

		// 로그인 안되었을때, 마이페이지를 클릭하면 로그인페이지로 리다이렉트해줌
		response.sendRedirect(request.getContextPath() + "/member/login");

		return false;

	}

}
