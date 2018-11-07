package com.team.springsns.manager.service;

import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.manager.dao.NoticeDao;
import com.team.springsns.manager.model.Notice;
import com.team.springsns.manager.model.NoticeListView;

@Service
public class GetNoticeListService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private NoticeDao noticeDao;

	// 한 페이지에 보여줄 공지사항의 수
	private static final int NOTICE_COUNT_PER_PAGE = 6;

	public NoticeListView getNoticeList(int pageNumber) {

		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);

		int currentPageNumber = pageNumber;

		// 전체 게시글 구하기
		int noticeTotalCount = noticeDao.selectCount();
		List<Notice> noticeList = null;
		int firstRow = 0;
		int endRow = 0;

		if (noticeTotalCount > 0) {

			firstRow = (pageNumber - 1) * NOTICE_COUNT_PER_PAGE;
			endRow = NOTICE_COUNT_PER_PAGE;
			noticeList = noticeDao.selectList(firstRow, endRow);

		} else {

			currentPageNumber = 0;
			noticeList = Collections.emptyList();

		}

		return new NoticeListView(noticeList, noticeTotalCount, currentPageNumber, NOTICE_COUNT_PER_PAGE, firstRow,
				endRow);
	}
}
