package com.bitcamp.manager.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bitcamp.manager.notice.dao.NoticeDao;
import com.bitcamp.manager.notice.model.Notice;

public class EditNoticeService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private NoticeDao noticeDao;

	@Transactional
	public void editNotice(@ModelAttribute Notice notice, int noticeNo) {
		
		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
		noticeDao.edit(noticeNo);
		
	}
	
	public Notice editForm(int noticeNo) {
		
		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
		return noticeDao.select(noticeNo);		
	}
	
}