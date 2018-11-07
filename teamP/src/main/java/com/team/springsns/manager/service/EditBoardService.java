package com.team.springsns.manager.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.manager.dao.ListDao;
import com.team.springsns.manager.model.Board;

@Service
public class EditBoardService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private ListDao listDao;
	
	@Transactional
	public int editBoard(Board board, HttpServletRequest request) throws IllegalStateException, IOException {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
	
		return listDao.edit_board(board);
	}
	
	public Board editForm(int boardNo) {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
		
		return listDao.select_board(boardNo);
	}

}
