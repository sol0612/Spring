package com.team.springsns.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.springsns.manager.service.DeleteMemberService;

@Controller
@RequestMapping("/list/delete_member")
public class MemberDeleteController {
	
	@Autowired
	private DeleteMemberService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String delete_member(@RequestParam("userNo") int userNo) {
		
		service.deleteMember(userNo);
		
		return "redirect:/list/memberList";
	}

}
