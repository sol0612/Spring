package com.bitcamp.op.guestbook.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.guestbook.dao.JdbcTemplateMessageDao;
import com.bitcamp.op.guestbook.model.Message;

public class ViewmessageService {
	
	@Autowired
	private JdbcTemplateMessageDao messageDao;

	
	public Message getMessage(int messageId) throws SQLException {
		
		Message resultObj = messageDao.select(messageId); 
		
		return  resultObj;
		
		
	}
}