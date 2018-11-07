package com.team.springsns.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.manager.service.GetCommentListService;

@Controller
public class CommentListController {
	
	@Autowired
	private GetCommentListService service;
	
	@RequestMapping(value="/list/commentList", method = RequestMethod.GET)
	public ModelAndView getCommentList() {
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("list/commentList");
		modelAndView.addObject("comments", service.getCommentList());

		return modelAndView;
		
	}

}
