package com.team.springsns.manager.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.manager.dao.ListDao;
import com.team.springsns.manager.model.Member;

@Service
public class GetMemberListService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private ListDao listDao;

	public List<Member> getMemberList() {
		
		listDao = sqlSessionTemplate.getMapper(ListDao.class);
				
		return listDao.select_member_list();
	}
}
