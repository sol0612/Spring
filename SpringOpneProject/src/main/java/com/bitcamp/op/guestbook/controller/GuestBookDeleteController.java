package com.bitcamp.op.guestbook.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.guestbook.model.Message;
import com.bitcamp.op.guestbook.service.DeleteMessageService;
import com.bitcamp.op.guestbook.service.InvalidMessagePasswordException;
import com.bitcamp.op.guestbook.service.MessageNotFoundException;
import com.bitcamp.op.guestbook.service.ServiceException;

@Controller
@RequestMapping("/guest/delete")
public class GuestBookDeleteController {

	@Autowired
	private DeleteMessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public String getDeleteForm(Model model, @RequestParam("id") int id) {

		// 여기에 저장된 데이터가 뷰에 전달됨!
		model.addAttribute("mId", id);
		
		return "guest/confirmDelete";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String deleteMessage(@RequestParam("id") int messageId)
			throws SQLException, ServiceException, InvalidMessagePasswordException, MessageNotFoundException {

		String viewName = "redirect:/guest/list";

		service.deleteMessage(messageId);

		return viewName;
	}
}
