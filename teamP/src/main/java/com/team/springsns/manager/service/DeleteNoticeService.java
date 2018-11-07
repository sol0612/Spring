package com.team.springsns.manager.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.manager.dao.NoticeDao;

@Service
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