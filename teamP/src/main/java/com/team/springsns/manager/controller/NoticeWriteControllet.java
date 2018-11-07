package com.team.springsns.manager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.springsns.manager.model.Notice;
import com.team.springsns.manager.service.WriteNoticeService;

@Controller
@RequestMapping("/notice/write")
public class NoticeWriteControllet {

	// 서비스클래스 의존성주입
	@Autowired
	private WriteNoticeService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getWriteForm() {

		return "notice/writeForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String writeMessage(Notice notice, HttpServletRequest request) throws IllegalStateException, IOException {

		int resultCnt = service.write(notice, request);

		if (resultCnt == 0) {
			return "notice/fail";
		}
		return "redirect:list";
	}

}
