package com.team.springsns.manager.model;

import org.springframework.web.multipart.MultipartFile;

public class Member {

	private int userNo;
	private String userId;
	private String userName;
	private String userPassword;
	private String userProfilePhoto;
	private String userIntro;
	private MultipartFile userFile;

	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserProfilePhoto() {
		return userProfilePhoto;
	}

	public String getUserIntro() {
		return userIntro;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserProfilePhoto(String userProfilePhoto) {
		this.userProfilePhoto = userProfilePhoto;
	}

	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}

	public MultipartFile getUserFile() {
		return userFile;
	}

	public void setUserFile(MultipartFile userFile) {
		this.userFile = userFile;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userProfilePhoto=" + userProfilePhoto + ", userIntro=" + userIntro + ", userFile="
				+ userFile + "]";
	}

}
