package com.bitcamp.op.guestbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.op.guestbook.model.Message;

public class JdbcTemplateMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Message message) throws SQLException {

		int resultCnt = 0;

		String sql = "insert into guestbook_message (guest_id, guest_name, message) values (?, ?, ?)";

		resultCnt = jdbcTemplate.update(sql, message.getGuestId(), message.getGuestName(), message.getMessage());

		return resultCnt;
	}

	public Message select(int messageId) throws SQLException {

		String sql = "select * from guestbook_message where message_id = ?";

		List<Message> message = jdbcTemplate.query(sql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {

				Message message = new Message();
				message.setId(messageId);

				return message;
			}

		}, messageId);

		return message.isEmpty() ? null : message.get(0);
	}

	public int selectCount() throws SQLException {

		String sql = "select count(*) from guestbook_message";

		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public List<Message> selectList(int firstRow, int endRow) throws SQLException {

		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";

		List<Message> message = jdbcTemplate.query(sql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {

				return makeMessageFromResultSet(rs);
			}

		}, firstRow, endRow);

		return message.isEmpty() ? null : message;

	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestId(rs.getString("guest_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	public int delete(int messageId) throws SQLException {

		String sql = "delete from guestbook_message where message_id = ?";
		return jdbcTemplate.update(sql, messageId);

	}
}
