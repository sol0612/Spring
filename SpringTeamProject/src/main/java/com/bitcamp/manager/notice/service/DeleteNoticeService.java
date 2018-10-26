package com.bitcamp.manager.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.manager.notice.dao.NoticeDao;

public class DeleteNoticeService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private NoticeDao noticeDao;

	@Transactional
	public void deleteNotice(int noticeNo) {
		
		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);

		noticeDao.select(noticeNo);
		noticeDao.delete(noticeNo);
		
	}
}