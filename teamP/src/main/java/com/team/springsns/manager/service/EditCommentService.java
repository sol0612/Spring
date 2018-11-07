package com.team.springsns.manager.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.manager.dao.ListDao;
import com.team.springsns.manager.model.Comment;

@Service
public class EditCommentService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private ListDao listDao;
	
	@Transactional
	public int editComment(Comment comment, HttpServletRequest request) throws IllegalStateException, IOException {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
		
		return listDao.edit_comment(comment);
	}
	
	public Comment editForm(int commentNo) {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
		
		return listDao.select_comment(commentNo);
	}

}
