package com.bitcamp.op;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.service.MemberListService;

@Controller
@RequestMapping("/member/list")
public class MemberListController {

	@Autowired
	private MemberListService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView view() throws SQLException {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("member/list");
		modelAndView.addObject("members", service.list());

		return modelAndView;

	}

	/*
	 * @RequestMapping(method = RequestMethod.POST) public ModelAndView view2()
	 * throws SQLException {
	 * 
	 * ModelAndView modelAndView = new ModelAndView();
	 * 
	 * modelAndView.setViewName("member/list");
	 * 
	 * return modelAndView; }
	 */
}
