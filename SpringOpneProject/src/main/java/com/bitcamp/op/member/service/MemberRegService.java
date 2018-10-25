package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.model.MemberInfo;

public class MemberRegService {

	@Autowired
	private JdbcTemplateMemberDao memberDao;

	private Connection conn;

	public int memberReg(MemberInfo memberInfo, HttpServletRequest request)
			throws SQLException, IllegalStateException, IOException {

		conn = ConnectionProvider.getConnection();
		int resultCnt = 0;

		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";
		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		// DB 저장용 파일 이름, 물리적 저장할때의 이름
		String imgName = "";

		if (!memberInfo.getPhotoFile().isEmpty()) {

			imgName = memberInfo.getUserId() + "_" + memberInfo.getPhotoFile().getOriginalFilename();

			// 물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));

			// DB 에 저장할 이름 SET
			memberInfo.setUserPhoto(imgName);
			
			System.out.println(dir);

		}

		try {
			conn.setAutoCommit(false);

			resultCnt = memberDao.insertMemberInfo(memberInfo);

			conn.commit();
		} catch (Exception e) {
			JdbcUtil.rollback(null);
			throw e;
		} finally {
			conn.setAutoCommit(false);
			JdbcUtil.close(conn);
		}

		return resultCnt;

	}
}
