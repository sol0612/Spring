package com.bitcamp.op;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.model.MemberInfo;
import com.bitcamp.op.member.service.MemberDeleteService;

@Controller
@RequestMapping("/member/delete")
public class MemberDeleteController {

	@Autowired
	private MemberDeleteService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getDeleteForm(HttpServletRequest request, Model model) {
		
		MemberInfo loginInfo = (MemberInfo) request.getSession(false).getAttribute("loginInfo");
		String userId = loginInfo.getUserId();

		model.addAttribute("mId", userId);
		
		return "member/ConfirmDelete";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String deleteMessage(@RequestParam("userId") String userId, HttpSession session) throws SQLException {

		String viewName = "redirect:/member/list";

		service.deleteMessage(userId);
		session.invalidate();

		return viewName;
	}
}