package com.test.board.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BoardModel {
	private int board_no;
	private String writer;
	private String password;
	private String title;
	private String content;
	private LocalDate date;
	private int hit;
	
	public BoardModel(){}
	
	public BoardModel(String writer, String password, String title, String content){
		this.writer = writer;
		this.password = password;
		this.title = title;
		this.content = content;
		this.date = LocalDate.now();
		this.hit = 0;
	}
	
	public BoardModel(int board_no, String writer, String password, String title, String content, LocalDate date){
		this.board_no = board_no;
		this.writer = writer;
		this.password = password;
		this.title = title;
		this.content = content;
		this.date = date;
		this.hit = 0;
	}
}
