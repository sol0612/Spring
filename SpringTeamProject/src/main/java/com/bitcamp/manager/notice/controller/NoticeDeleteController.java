package com.bitcamp.manager.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.manager.notice.service.DeleteNoticeService;

@Controller
@RequestMapping("/notice/delete")
public class NoticeDeleteController {

	@Autowired
	private DeleteNoticeService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getDeleteForm(Model model, @RequestParam("noticeNo") int noticeNo) {

		model.addAttribute("mId", noticeNo);
		
		return "notice/confirmDelete";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String deleteNotice(@RequestParam("noticeNo") int noticeNo) {

		service.deleteNotice(noticeNo);

		return "redirect:/notice/list";
	}
}
