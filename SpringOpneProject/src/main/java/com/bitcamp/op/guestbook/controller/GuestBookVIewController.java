package com.bitcamp.op.guestbook.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.guestbook.model.Message;
import com.bitcamp.op.guestbook.service.ViewmessageService;

@Controller
public class GuestBookVIewController {
	
	@Autowired
	private ViewmessageService service;
	
	@RequestMapping("/guest/view/${id}")
	public String getView(
			@PathVariable("messageId") int id,
			Model model,
			HttpSession session
			) throws SQLException {
		
		Message message = service.getMessage(id);
		model.addAttribute("msg", message);
		
		session.setAttribute("login", message);
		
		model.addAttribute("id", id);
		
		System.out.println(message);
		
		return "guest/view";
	}
	
}