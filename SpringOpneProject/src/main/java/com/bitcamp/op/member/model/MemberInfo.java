package com.bitcamp.op.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {

	private int idx;
	private String userId;
	private String password;
	private String userName;
	private String userPhoto; // DB에 저장할 파일 이름
	private MultipartFile photoFile; // form에 저장한 이름으로 받을 객체이름

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", userId=" + userId + ", password=" + password + ", userName=" + userName
				+ ", userPhoto=" + userPhoto + ", photoFile=" + photoFile + "]";
	}

}
