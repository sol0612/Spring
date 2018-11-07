package com.team.springsns.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.springsns.manager.service.DeleteCommentService;

@Controller
@RequestMapping("/list/delete_comment")
public class CommentDeleteController {
	
	@Autowired
	private DeleteCommentService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String delete_comment(@RequestParam("commentNo") int commentNo) {
		
		service.deleteComment(commentNo);
		
		return "redirect:/list/commentList";
	}

}
