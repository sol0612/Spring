package com.bitcamp.op.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.op.member.model.MemberInfo;

public class JdbcTemplateMemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertMemberInfo(MemberInfo memberInfo) throws SQLException {

		int resultCnt = 0;

		String insert_sql = "insert into member (userid, password, username, userphoto ) values(?, ?, ?, ?)";
		resultCnt = jdbcTemplate.update(insert_sql, 
				memberInfo.getUserId(), 
				memberInfo.getPassword(),
				memberInfo.getUserName(),
				memberInfo.getUserPhoto());

		return resultCnt;

	}

	public MemberInfo getMemberInfo(String id) {

		String sql = "select * from member where userid=?";

		List<MemberInfo> result = jdbcTemplate.query(sql, new RowMapper<MemberInfo>() {

			@Override
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setUserId(rs.getString("userid"));
				memberInfo.setPassword(rs.getString("password"));
				memberInfo.setUserName(rs.getString("username"));
				memberInfo.setUserPhoto(rs.getString("userphoto"));

				return memberInfo;
			}

		}, id);

		return result.isEmpty() ? null : result.get(0);
	}

	public List<MemberInfo> listView() {

		String sql = "SELECT * FROM MEMBER";

		List<MemberInfo> members = jdbcTemplate.query(sql, new RowMapper<MemberInfo>() {

			@Override
			public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

				MemberInfo memberInfo = new MemberInfo();
				memberInfo.setUserId(rs.getString("userid"));
				memberInfo.setPassword(rs.getString("password"));
				memberInfo.setUserName(rs.getString("username"));
				memberInfo.setUserPhoto(rs.getString("userphoto"));

				return memberInfo;
			}
		});

		return members.isEmpty() ? null : members;

	}
	
	public int remove(String userid) {
		
		String sql = "delete from MEMBER where userid=?";
		return jdbcTemplate.update(sql, userid);
	}

}
