package com.bitcamp.manager.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.manager.notice.model.Notice;
import com.bitcamp.manager.notice.service.EditNoticeService;

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
	public String editNotice(
			@RequestParam("noticeNo") int noticeNo,
			@RequestParam("noticeTitle") String noticeTitle,
			@RequestParam("noticeWriter") String noticeWriter,
			@RequestParam("noticeCont") String noticeCont) {

		service.editNotice(noticeNo, noticeTitle, noticeWriter, noticeCont);
		
		return "redirect:/notice/view";
	}
}
