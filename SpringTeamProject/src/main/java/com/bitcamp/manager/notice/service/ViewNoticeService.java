package com.bitcamp.manager.notice.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.manager.notice.dao.NoticeDao;
import com.bitcamp.manager.notice.model.Notice;


public class ViewNoticeService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private NoticeDao noticeDao;
	
	public Notice getNotice(int noticeNo) throws IllegalStateException, IOException {
		
		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
		
		return  noticeDao.select(noticeNo); 
		
	}
}