package com.team.springsns.manager.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.manager.dao.ListDao;
import com.team.springsns.manager.model.Member;

@Service
public class EditMemberService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private ListDao listDao;
	
	@Transactional
	public int editMember(Member member, HttpServletRequest request) throws IllegalStateException, IOException {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
		
		return listDao.edit_member(member);
	}
	
	public Member editForm(int userNo) {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
		
		return listDao.select_member(userNo);
	}

}
