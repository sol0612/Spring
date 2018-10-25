package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberListService {

	@Autowired
	/*private MemberDao memberDao;*/
	private JdbcTemplateMemberDao memberDao;

	public List<MemberInfo> list() throws SQLException {

		Connection conn = ConnectionProvider.getConnection();

		return memberDao.listView();

	}

}
