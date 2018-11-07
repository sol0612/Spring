package com.team.springsns.manager.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.manager.dao.NoticeDao;
import com.team.springsns.manager.model.Notice;

@Service
public class ViewNoticeService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private NoticeDao noticeDao;
	
	public Notice getNotice(int noticeNo) throws IllegalStateException, IOException {
		
		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
		return  noticeDao.select(noticeNo); 
		
	}
	
	public void updateHits(int noticeNo) {

		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
		noticeDao.updateHits(noticeNo);

	}
}