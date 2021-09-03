package com.example.test.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BoardDTO {
	private int board_no;
	private String writer;
	private String password;
	private String title;
	private String content;
	private LocalDate date;
	
	public BoardDTO(){}
	
	public BoardDTO(BoardDTO board) {
		this.board_no = board.board_no;
		this.writer = board.writer;
		this.title = board.title;
		this.content = board.content;
		this.date = board.date;
	}
	
	public BoardDTO(String writer, String password, String title, String content){
		this.writer = writer;
		this.password = password;
		this.title = title;
		this.content = content;
		this.date = LocalDate.now();
	}
	
	public BoardDTO(int board_no, String writer, String password, String title, String content, LocalDate date){
		this.board_no = board_no;
		this.writer = writer;
		this.password = password;
		this.title = title;
		this.content = content;
		this.date = date;
	}
}