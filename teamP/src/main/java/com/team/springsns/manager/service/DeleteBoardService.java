package com.team.springsns.manager.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.manager.dao.ListDao;

@Service
public class DeleteBoardService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private ListDao listDao;
	
	@Transactional
	public void deleteBoard(int boardNo) {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
		
		listDao.select_board(boardNo);
		listDao.delete_board(boardNo);
	}

}
