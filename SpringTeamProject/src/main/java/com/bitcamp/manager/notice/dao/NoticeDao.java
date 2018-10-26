package com.bitcamp.manager.notice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bitcamp.manager.notice.model.Notice;


public interface NoticeDao {
	
	public int insert(Notice notice); // 게시글추가메서드
	public Notice select(int noticeNo); //게시글 하나 나태내줄 메서드
	public int selectCount(); //게시글카운트메서드
	public List<Notice> selectList(@Param("firstRow") int firstRow, @Param("endRow") int endRow); //게시글 리스트 나타내줄 메서드
	public int delete(@Param("noticeNo") int noticeNo); // 게시글 삭제메서드
	public int edit(@Param("noticeNo") int noticeNo);
	
}
