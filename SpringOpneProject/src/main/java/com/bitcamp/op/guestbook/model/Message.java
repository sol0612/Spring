package com.bitcamp.op.guestbook.model;

public class Message {

	private int id;
	private String guestId;
	private String guestName;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", guestId=" + guestId + ", guestName=" + guestName + ", message=" + message + "]";
	}

}
