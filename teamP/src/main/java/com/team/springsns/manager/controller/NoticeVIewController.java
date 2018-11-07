package com.team.springsns.manager.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.manager.model.Notice;
import com.team.springsns.manager.service.ViewNoticeService;

@Controller
public class NoticeVIewController {

	@Autowired
	private ViewNoticeService service;

	@RequestMapping(value="/notice/view", method=RequestMethod.GET)
	public ModelAndView getView(@RequestParam("noticeNo") int noticeNo) throws SQLException, IllegalStateException, IOException {

		Notice viewData = service.getNotice(noticeNo);
		service.updateHits(noticeNo);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("notice/view");
		modelAndView.addObject("viewData", viewData);

		return modelAndView;
	}

}