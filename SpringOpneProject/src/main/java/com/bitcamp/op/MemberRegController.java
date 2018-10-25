package com.bitcamp.op;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {

	@Autowired //서비스 클래스 의존성 주입
	private MemberRegService regService;

	//GET방식으로 들어갔을 떄, Form띄워주기
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginForm() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberRegForm");
		// /WEB-INF/ .jsp
		return modelAndView;

	}

	//POST방식으로 들어갔을 떄, DB에 정보가 잘 들어갔으면 regok 아니면 regFail
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView memberReg(MemberInfo member, HttpServletRequest request) {

		/*
		 * String userId = request.getParameter("userId");
		 * System.out.println("userId : " + userId); System.out.println(member);
		 */

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("member/regok");

		try {
			int resultCnt = regService.memberReg(member, request);

			if (resultCnt == 0) {
				modelAndView.setViewName("member/regFail");
			}
		} catch (SQLException e) {

			modelAndView.setViewName("member/regFail");
			e.printStackTrace();

		} catch (IllegalStateException e) {

			modelAndView.setViewName("member/regFail");
			e.printStackTrace();

		} catch (IOException e) {

			modelAndView.setViewName("member/regFail");
			e.printStackTrace();

		}

		return modelAndView;

	}
}
