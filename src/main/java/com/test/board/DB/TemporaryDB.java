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
			++board_no;
		}
	}
	
	
	// method
	public LinkedList<BoardModel> getBoards() {
		return boards;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	
	public void plusBoard_no() {
		board_no++;
	}
}
