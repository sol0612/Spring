package com.team.springsns.manager.dao;

import java.util.List;

import com.team.springsns.manager.model.Board;
import com.team.springsns.manager.model.Comment;
import com.team.springsns.manager.model.Member;

public interface ListDao {
	
	public List<Member> select_member_list();
	public List<Board> select_board_list();
	public List<Comment> select_comment_list();
	public Member select_member(int userNo);
	public Board select_board(int boardNo);
	public Comment select_comment(int commentNo);
	public int edit_member(Member member);
	public int edit_board(Board board);
	public int edit_comment(Comment comment);
	public int delete_member(int userNo);
	public int delete_board(int boardNo);
	public int delete_comment(int commentNo);

}
