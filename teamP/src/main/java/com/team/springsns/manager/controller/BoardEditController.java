package com.team.springsns.manager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.manager.model.Board;
import com.team.springsns.manager.service.EditBoardService;

@Controller
@RequestMapping("/list/edit_board")
public class BoardEditController {
	
	@Autowired
	private EditBoardService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getEditForm(@RequestParam("boardNo") int boardNo) {
		
		ModelAndView modelAndView = new ModelAndView();
		Board board = service.editForm(boardNo);
		
		modelAndView.setViewName("/list/BoardeditForm");
		modelAndView.addObject("board", board);
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String editBoard(Board board, HttpServletRequest request) throws IllegalStateException, IOException {
		
		service.editBoard(board, request);
		
		return "redirect:/list/boardList";
	}

}
