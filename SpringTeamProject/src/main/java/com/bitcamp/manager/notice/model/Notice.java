package com.bitcamp.manager.notice.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Notice {

	private int noticeNo; // 게시글넘버
	private String noticeTitle; // 게시글제목
	private String noticeWriter; // 게시글작성자 default='manager'
	private String noticeCont; // 게시글 내용
	private String noticePhoto; // DB에 저장할 파일 이름
	private MultipartFile noticeFile; // form에 저장한 이름으로 받을 객체이름
	private Timestamp noticeDate; // 작성시간

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeCont() {
		return noticeCont;
	}

	public void setNoticeCont(String noticeCont) {
		this.noticeCont = noticeCont;
	}

	public String getNoticePhoto() {
		return noticePhoto;
	}

	public void setNoticePhoto(String noticePhoto) {
		this.noticePhoto = noticePhoto;
	}

	public MultipartFile getNoticeFile() {
		return noticeFile;
	}

	public void setNoticeFile(MultipartFile noticeFile) {
		this.noticeFile = noticeFile;
	}

	public Timestamp getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Timestamp noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeWriter=" + noticeWriter + ", noticeTitle=" + noticeTitle
				+ ", noticeCont=" + noticeCont + ", noticePhoto=" + noticePhoto + ", noticeFile=" + noticeFile
				+ ", noticeDate=" + noticeDate + "]";
	}

}
