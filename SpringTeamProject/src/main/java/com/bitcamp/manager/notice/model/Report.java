package com.bitcamp.manager.notice.model;

public class Report {

	private int noticeNo;
	private int userNo;

	public int getNoticeNo() {
		return noticeNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "Report [noticeNo=" + noticeNo + ", userNo=" + userNo + "]";
	}

}
