package com.bitcamp.manager.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.manager.notice.service.ReportNoticeService;

@Controller
@RequestMapping("/notice/report")
public class NoticeReportController {
	
	@Autowired
	private ReportNoticeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String report(Model model, @RequestParam("noticeNo") int noticeNo) {
		
		model.addAttribute("mId", noticeNo);
		
		return "notice/confirmReport";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String reportUpdate(@RequestParam("noticeNo") int noticeNo) {
		
		service.reportCnt(noticeNo);
		int result = service.getReport(noticeNo);
		
		if(result >= 3) {
			service.updateReport(noticeNo);
		}
		
		return "redirect:/notice/list";
	}

}
