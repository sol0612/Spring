package com.team.springsns.manager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.manager.model.Member;
import com.team.springsns.manager.service.EditMemberService;

@Controller
@RequestMapping("/list/edit_member")
public class MemberEditController {
	
	@Autowired
	private EditMemberService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getEditForm(@RequestParam("userNo") int userNo) {
		
		ModelAndView modelAndView = new ModelAndView();
		Member member = service.editForm(userNo);
		
		modelAndView.setViewName("/list/MembereditForm");
		modelAndView.addObject("members", member);
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String editMember(Member member, HttpServletRequest request) throws IllegalStateException, IOException {
		
		service.editMember(member, request);
		
		return "redirect:/list/memberList";
	}

}
