package com.team.springsns.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.manager.service.GetMemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private GetMemberListService service;
	
	@RequestMapping(value="/list/memberList", method = RequestMethod.GET)
	public ModelAndView getMemberList() {
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("list/memberList");
		modelAndView.addObject("members", service.getMemberList());

		return modelAndView;
		
	}

}
