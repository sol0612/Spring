package com.team.springsns.manager.model;

import java.sql.Timestamp;

public class Comment {

	private int commentNo;
	private int boardNo;
	private String userId;
	private String commentCont;
	private Timestamp commentDate;

	public int getCommentNo() {
		return commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getCommentCont() {
		return commentCont;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCommentCont(String commentCont) {
		this.commentCont = commentCont;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", boardNo=" + boardNo + ", userId=" + userId + ", commentCont="
				+ commentCont + ", commentDate=" + commentDate + "]";
	}

}
