package com.team.springsns.manager.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.manager.dao.ListDao;

@Service
public class DeleteCommentService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private ListDao listDao;
	
	@Transactional
	public void deleteComment(int commentNo) {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
		
		listDao.select_comment(commentNo);
		listDao.delete_comment(commentNo);
	}

}
