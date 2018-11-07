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
import com.team.springsns.manager.model.Comment;
import com.team.springsns.manager.service.EditBoardService;
import com.team.springsns.manager.service.EditCommentService;

@Controller
@RequestMapping("/list/edit_comment")
public class CommentEditController {
	
	@Autowired
	private EditCommentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getEditForm(@RequestParam("commentNo") int commentNo) {
		
		ModelAndView modelAndView = new ModelAndView();
		Comment comment = service.editForm(commentNo);
		
		modelAndView.setViewName("/list/CommenteditForm");
		modelAndView.addObject("comment", comment);
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String editComment(Comment comment, HttpServletRequest request) throws IllegalStateException, IOException {
		
		service.editComment(comment, request);
		
		return "redirect:/list/commentList";
	}

}
