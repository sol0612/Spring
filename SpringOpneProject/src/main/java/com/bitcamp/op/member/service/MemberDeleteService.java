package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;

public class MemberDeleteService {

	@Autowired
	JdbcTemplateMemberDao memberDao;

	public void deleteMessage(@RequestParam("userId") String userId) throws SQLException {
		
		Connection conn = null;

		conn = ConnectionProvider.getConnection();
		conn.setAutoCommit(false);
		
		memberDao.getMemberInfo(userId);
		memberDao.remove(userId);
		conn.commit();
		
		

	}
}
