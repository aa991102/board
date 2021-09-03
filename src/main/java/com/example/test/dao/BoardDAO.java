package com.example.test.dao;

import java.util.List;
import java.util.Map;

import com.example.test.dto.BoardDTO;

public interface BoardDAO {
	// 게시글 리스트 가져오기(READ-All)
	List<BoardDTO> selectBoards();
	
	// 게시글 번호로 게시글 내용 가져오기(READ-One)
	BoardDTO selectBoard(int board_no);
	
	// 게시글 생성(CREATE)
	int insertBoard(BoardDTO board);
	
	// 게시글 수정(UPDATE)
	int updateBoard(BoardDTO board);
	
	// 게시글 삭제(DELETE)
	int deleteBoard(int board_no);
	
	// 게시글 번호와 비밀번호 파라미터가 실제 게시글 내용과 일치하는지 확인
	int selectCountByBoardNoAndPassword(BoardDTO board);
	
}
