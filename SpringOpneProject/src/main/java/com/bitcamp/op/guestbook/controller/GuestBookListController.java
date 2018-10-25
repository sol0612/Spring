package com.bitcamp.op.guestbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.guestbook.model.MessageListView;
import com.bitcamp.op.guestbook.service.GetMessageListService;
import com.bitcamp.op.guestbook.service.ServiceException;

@Controller
public class GuestBookListController {

	// 서비스클래스 자동의존설정해주기 ★★★★★
	@Autowired
	private GetMessageListService service;

	@RequestMapping("/guest/list")
	public ModelAndView getGuestList(HttpServletRequest request) throws ServiceException {

		String pageNumberStr = request.getParameter("page");
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		MessageListView viewData = service.getMessageList(pageNumber);

		ModelAndView modelAndView = new ModelAndView();

		// view name 설정
		modelAndView.setViewName("guest/list");

		// view에 결과 데이터를 전달(공유)
		modelAndView.addObject("viewData", viewData);

		return modelAndView;
	}

}
