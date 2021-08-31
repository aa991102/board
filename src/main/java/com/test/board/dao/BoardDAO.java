package com.test.board.dao;

import java.time.LocalDate;
import java.util.LinkedList;

import com.test.board.DB.TemporaryDB;
import com.test.board.model.BoardModel;

public class BoardDAO {
	TemporaryDB db = new TemporaryDB();
	
	// 게시글 리스트 가져오기(READ-All)
	public LinkedList<BoardModel> getBoardList(){
		LinkedList<BoardModel> copy = new LinkedList<>();
		
		for(BoardModel board : db.getBoards()) {
			copy.add(new BoardModel(board));
		}
		
		return copy;
	}
	
	// 게시글 번호로 게시글 내용 가져오기(READ-One)
	public BoardModel getBoard(int board_no) {
		for(BoardModel board : db.getBoards()) {
			if(board.getBoard_no() == board_no) {
				return new BoardModel(board);
			}
		}
		return null; // 일치하는 게시글이 없는 경우
	}
	
	// 게시글 생성(CREATE)
	public int addBoard(BoardModel board) {
		int board_no = db.getBoard_no();
		
		board.setBoard_no(board_no);
		board.setDate(LocalDate.now());
		db.getBoards().add(board);
		db.plusBoard_no();
		
		return board_no;
	}
	
	// 게시글 수정(UPDATE)
	public int updateBoard(BoardModel board) {
		int update_index = getIndexByBoard_no(board.getBoard_no());
		
		if(update_index == -1) { // 수정할 게시글이 없는 경우 
			return 0;
		}else { // 수정할 게시글이 있는 경우
			BoardModel before_board = db.getBoards().get(update_index);
			board.setDate(before_board.getDate());
			db.getBoards().set(update_index, board);
			return 1;
		}
	}
	
	// 게시글 삭제(DELETE)
	public int deleteBoard(int board_no) {
		int delete_index = getIndexByBoard_no(board_no);
		
		if(delete_index == -1) { // 삭제할 게시글이 없는 경우
			return 0;
		}else { // 삭제할 게시글이 있는 경우
			db.getBoards().remove(delete_index);
			return 1;
		}
	}
	
	// 게시글 번호와 비밀번호 파라미터가 실제 게시글 내용과 일치하는지 확인
	public boolean checkPassword(int board_no, String password) {
		int index = getIndexByBoard_no(board_no);
		
		if(index != -1) {
			if(db.getBoards().get(index).getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
	
	// 게시글 번호로 boards에서의 인덱스 번호 찾기
	private int getIndexByBoard_no(int board_no) {
		int index_no = -1;
		
		for(int i=0; i<db.getBoards().size(); i++) {
			if(db.getBoards().get(i).getBoard_no() == board_no) {
				index_no = i;
				break;
			}
		}
		
		return index_no;
	}
}
