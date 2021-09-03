package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class BoardViewController {
	
	@RequestMapping
	public String boardMain() {
		return "content/main";
	}
	
	@RequestMapping(value = "/list")
	public String getBoardList() {
		return "content/list";
	}
	
	@RequestMapping("/detail/{board_no}")
	public String boardDetail(@PathVariable int board_no, Model model) {
		model.addAttribute("board_no", board_no);
		return "content/detail";
	}
	
	@RequestMapping("/write")
	public String insertBoard() {
		return "content/write";
	}
	
	@RequestMapping("/update/{board_no}")
	public String updateBoard(@PathVariable int board_no, Model model) {
		model.addAttribute("board_no", board_no);
		return "content/update";
	}
	
	@RequestMapping("/delete/{board_no}")
	public String deleteBoard(@PathVariable int board_no) {
		return "content/delete_check_password";
	}
}
