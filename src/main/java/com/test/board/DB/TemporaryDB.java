package com.test.board.DB;

import java.time.LocalDate;
import java.util.LinkedList;

import com.test.board.model.BoardModel;

public class TemporaryDB {
	// member 
	private static LinkedList<BoardModel> boards;
	private static int board_no = 0;


	// constructor
	public TemporaryDB(){
		if(boards == null) { // 처음 접근한 경우
			boards = new LinkedList<>();

			// 기본 데이터 입력
			boards.add(new BoardModel(++board_no, "짱구", "0000", "노는게 제일 좋아", "이건 뽀로로인가", LocalDate.of(2021, 8, 27)));
			boards.add(new BoardModel(++board_no, "철수", "1111", "영어학원 가야해", "Hello, My name is 철수. nice to meet you!!", LocalDate.of(2021, 8, 28)));
			boards.add(new BoardModel(++board_no, "유리", "2222", "소꿉놀이가 최고야", "오늘은 어떤 대본으로 할래?", LocalDate.of(2021, 8, 29)));
			boards.add(new BoardModel(++board_no, "훈이", "3333", "유리가 무서워", "이거 익명 맞나?", LocalDate.of(2021, 8, 30)));
			boards.add(new BoardModel(++board_no, "맹구", "4444", "희귀한 돌맹이", "찾았다.", LocalDate.of(2021, 8, 31)));
		}
	}
	
	
	// method
	// 게시글 리스트 가져오기(READ-All)
	public LinkedList<BoardModel> getBoardList(){
		LinkedList<BoardModel> copy = new LinkedList<>();
		
		for(BoardModel board : boards) {
			copy.add(new BoardModel(board));
		}
		
		return copy;
	}
	
	// 게시글 번호로 게시글 내용 가져오기(READ-One)
	public BoardModel getBoard(int board_no) {
		BoardModel copy;
		
		for(BoardModel board : boards) {
			if(board.getBoard_no() == board_no) {
				return new BoardModel(board);
			}
		}
		return null; // 일치하는 게시글이 없는 경우
	}
	
	// 게시글 생성(CREATE)
	public int addBoard(BoardModel board) {
		board.setBoard_no(board_no);
		boards.add(board);
		
		return board_no++;
	}
	
	// 게시글 수정(UPDATE)
	public int updateBoard(BoardModel board) {
		int update_index_no = getIndexByBoard_no(board.getBoard_no());
		
		if(update_index_no == -1) { // 수정할 게시글이 없는 경우 
			return 0;
		}else { // 수정할 게시글이 있는 경우
			boards.set(update_index_no, board);
			return 1;
		}
	}
	
	// 게시글 삭제(DELETE)
	public int deleteBoard(int board_no) {
		int delete_index_no = getIndexByBoard_no(board_no);
		
		if(delete_index_no == -1) { // 삭제할 게시글이 없는 경우
			return 0;
		}else { // 삭제할 게시글이 있는 경우
			boards.remove(delete_index_no);
			return 1;
		}
	}
	
	// 게시글 번호로 boards에서의 인덱스 번호 찾기
	private int getIndexByBoard_no(int board_no) {
		int index_no = -1;
		
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getBoard_no() == board_no) {
				index_no = i;
				break;
			}
		}
		
		return index_no;
	}
}
