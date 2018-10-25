package com.bitcamp.op;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	
	@Autowired
	private MemberLoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginForm(/* @RequestParam(value="no", required=false) int num */) {

		return new ModelAndView("member/loginForm");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginProcess(
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "password", required = true) String password,
			HttpSession session) throws SQLException {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/loginFail");	// default를 loginFail로 해주면 else문 작성 필요가 없음

		if (userId != null && password != null) {
			
			// service class에서 받은 값이 true이면 loginok로 이동
			if(loginService.login(userId, password, session)) {
				
				modelAndView.setViewName("redirect:/");

			}
		
		}
		
		return modelAndView;
	}

}
