package com.team.springsns.manager.model;

import java.util.List;

public class NoticeListView {
	private int noticeTotalCount; // 전체게시글수
	private int currentPageNumber; // 페이지넘버
	private List<Notice> noticeList; // 게시글리스트
	private int pageTotalCount; // 페이지전체갯수
	private int noticeCountPerPage; // 페이지당 게시글 수?
	private int firstRow;
	private int endRow;

	public NoticeListView(List<Notice> noticeList, int noticeTotalCount, int currentPageNumber, int noticeCountPerPage,
			int firstRow, int endRow) {
		this.noticeList = noticeList;
		this.noticeTotalCount = noticeTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.noticeCountPerPage = noticeCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		
		calculatePageTotalCount();
	}

	private void calculatePageTotalCount() {
		if (noticeTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = noticeTotalCount / noticeCountPerPage;
			if (noticeTotalCount % noticeCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	public boolean isEmpty() {
		return noticeTotalCount == 0;
	}

	public int getNoticeTotalCount() {
		return noticeTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getNoticeCountPerPage() {
		return noticeCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

}
