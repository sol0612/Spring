package com.team.springsns.manager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.manager.model.NoticeListView;
import com.team.springsns.manager.service.GetNoticeListService;

@Controller
public class NoticeListController {

	// 서비스클래스 자동의존설정해주기 ★★★★★
	@Autowired
	private GetNoticeListService service;

	@RequestMapping("/notice/list")
	public ModelAndView getNoticeList(HttpServletRequest request) {

		String pageNumberStr = request.getParameter("page");
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		NoticeListView viewData = service.getNoticeList(pageNumber);

		ModelAndView modelAndView = new ModelAndView();

		// view name 설정
		modelAndView.setViewName("notice/list");

		// view에 결과 데이터를 전달(공유)
		modelAndView.addObject("viewData", viewData);
		
		return modelAndView;
	}

}
