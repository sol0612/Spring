package com.team.springsns.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.manager.service.GetBoardListService;

@Controller
public class BoardListController {
	
	@Autowired
	private GetBoardListService service;
	
	@RequestMapping(value="/list/boardList", method = RequestMethod.GET)
	public ModelAndView getBoardList() {
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("list/boardList");
		modelAndView.addObject("boards", service.getBoardList());

		return modelAndView;
		
	}

}
