package com.team.springsns.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.springsns.manager.service.DeleteBoardService;

@Controller
@RequestMapping("/list/delete_board")
public class BoardDeleteController {
	
	@Autowired
	private DeleteBoardService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String delete_board(@RequestParam("boardNo") int boardNo) {
		
		service.deleteBoard(boardNo);
		
		return "redirect:/list/boardList";
	}

}
