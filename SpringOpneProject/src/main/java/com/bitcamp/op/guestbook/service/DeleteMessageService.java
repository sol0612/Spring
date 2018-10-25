package com.bitcamp.op.guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.guestbook.dao.JdbcTemplateMessageDao;
import com.bitcamp.op.jdbc.ConnectionProvider;

public class DeleteMessageService {

	@Autowired
	JdbcTemplateMessageDao messageDao;

	public void deleteMessage(int messageId)
			throws ServiceException, InvalidMessagePasswordException, MessageNotFoundException, SQLException {
		Connection conn = null;
		conn = ConnectionProvider.getConnection();
		conn.setAutoCommit(false);

		messageDao.select(messageId);
		messageDao.delete(messageId);
		conn.commit();
	}
}