package com.bitcamp.manager.notice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bitcamp.manager.notice.model.Notice;


public interface NoticeDao {
	
	public int insert(Notice notice); // 게시글추가
	public Notice select(int noticeNo); //게시글 하나 나타내줌
	public int selectCount(); //게시글카운트
	public List<Notice> selectList(@Param("firstRow") int firstRow, @Param("endRow") int endRow); //게시글 리스트
	public int delete(int noticeNo); // 게시글 삭제
	public int edit(Notice notice); // 게시글 수정
	public int reportCnt(int noticeNo); // 신고건수
	public int report(int noticeNo); // 신고받은 게시글 바꿔주기
	public int reportUp(int noticeNo); // 추가
	
}
