package com.bitcamp.op.guestbook.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.guestbook.dao.JdbcTemplateMessageDao;
import com.bitcamp.op.guestbook.model.Message;
import com.bitcamp.op.guestbook.model.MessageListView;

public class GetMessageListService {
	
	@Autowired
	JdbcTemplateMessageDao messageDao;

	// 한 페이지에 보여줄 메시지의 수
	private static final int MESSAGE_COUNT_PER_PAGE = 4;

	public MessageListView getMessageList(int pageNumber) throws ServiceException {
	
		int currentPageNumber = pageNumber;
		
		try {
			
			// 전체 메시지 구하기
			int messageTotalCount = messageDao.selectCount();
			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			
			if (messageTotalCount > 0) {
				
				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE;
				messageList = messageDao.selectList(firstRow, endRow);
				
			} else {
				
				currentPageNumber = 0;
				messageList = Collections.emptyList();
				
			}
			
			return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
					firstRow, endRow);
			
		} catch (SQLException e) {
			
			throw new ServiceException("메시지 목록 구하기 실패: " + e.getMessage(), e);
			
		} 
	}
}