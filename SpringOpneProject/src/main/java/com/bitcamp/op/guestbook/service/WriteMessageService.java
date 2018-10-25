package com.bitcamp.op.guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.guestbook.dao.JdbcTemplateMessageDao;
import com.bitcamp.op.guestbook.model.Message;

public class WriteMessageService {
	
	@Autowired
	JdbcTemplateMessageDao messageDao;

	public void write(Message message) throws ServiceException {
		Connection conn = null;
		try {
			
			conn = ConnectionProvider.getConnection();
			messageDao.insert(message);
			
		} catch (SQLException e) {
			
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
			
		} finally {
			
			JdbcUtil.close(conn);
			
		}
	}
}
