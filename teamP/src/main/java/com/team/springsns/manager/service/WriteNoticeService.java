package com.team.springsns.manager.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.manager.dao.NoticeDao;
import com.team.springsns.manager.model.Notice;

@Service
public class WriteNoticeService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private NoticeDao noticeDao;

	@Transactional
	public int write(Notice notice, HttpServletRequest request) throws IllegalStateException, IOException {

		noticeDao = sqlSessionTemplate.getMapper(NoticeDao.class);
	
		// 물리적 저장 경로
				String uploadUri = "/uploadfile";

				// uploadUri 경로의 시스템 경로
				String dir = request.getSession().getServletContext().getRealPath(uploadUri);

				// DB 저장용 파일 이름, 물리적 저장할때의 이름
				String imgName = "";

				if (!notice.getNoticeFile().isEmpty()) {

					imgName = notice.getNoticeNo() + "_" + notice.getNoticeFile().getOriginalFilename();

					// 물리적 저장
					notice.getNoticeFile().transferTo(new File(dir, imgName));

					// DB 에 저장할 이름 SET
					notice.setNoticePhoto(imgName);
				}
				
		return noticeDao.insert(notice);
	}
}
