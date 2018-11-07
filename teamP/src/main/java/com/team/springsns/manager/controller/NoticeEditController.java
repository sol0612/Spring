package com.team.springsns.manager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.manager.model.Notice;
import com.team.springsns.manager.service.EditNoticeService;

@Controller
@RequestMapping("/notice/edit")
public class NoticeEditController {

	@Autowired
	private EditNoticeService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEditForm(@RequestParam("noticeNo") int noticeNo) {

		ModelAndView modelAndView = new ModelAndView();
		Notice notice = service.editForm(noticeNo);
		
		modelAndView.setViewName("/notice/editForm");
		modelAndView.addObject("notice", notice);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String editNotice(Notice notice, HttpServletRequest request) throws IllegalStateException, IOException {

		service.editNotice(notice, request);
		return "redirect:/notice/list";
	}
}
