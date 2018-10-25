package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.guestbook.model.Message;
import com.bitcamp.op.guestbook.service.ServiceException;
import com.bitcamp.op.guestbook.service.WriteMessageService;

@Controller
@RequestMapping("/guest/write")
public class GuestBookWriteControllet {

	// 서비스클래스 의존성주입
	@Autowired
	private WriteMessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getWriteForm() {

		return "guest/writeForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String writeMessage(Message message) throws ServiceException {

		service.write(message);

		return "guest/write";
	}

}
