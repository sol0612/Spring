package com.bitcamp.manager.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.manager.notice.dao.NoticeDao;

public class ReportNoticeService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private NoticeDao noticeDao;
	
	public int getReport(int noticeNo) {
		
		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
		return noticeDao.reportCnt(noticeNo);
	}
	
	public int updateReport(int noticeNo) {
		
		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
		return noticeDao.report(noticeNo);
	}
	
	@Transactional
	public int reportCnt(int noticeNo) {
		
		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
		return noticeDao.reportUp(noticeNo);
		
	}

}
