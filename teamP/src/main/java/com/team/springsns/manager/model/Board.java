package com.team.springsns.manager.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Board {

	private int boardNo;
	private int userNo;
	private String boardContent;
	private String boardPhoto;
	private String hashTag;
	private Timestamp boardDate;
	private MultipartFile boardFile;

	public int getBoardNo() {
		return boardNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public String getBoardPhoto() {
		return boardPhoto;
	}

	public String getHashTag() {
		return hashTag;
	}

	public Timestamp getBoardDate() {
		return boardDate;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}


	public MultipartFile getBoardFile() {
		return boardFile;
	}

	public void setBoardFile(MultipartFile boardFile) {
		this.boardFile = boardFile;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", userNo=" + userNo + ", boardContent=" + boardContent + ", boardPhoto="
				+ boardPhoto + ", hashTag=" + hashTag + ", boardDate=" + boardDate + ", boardFile=" + boardFile + "]";
	}

}
