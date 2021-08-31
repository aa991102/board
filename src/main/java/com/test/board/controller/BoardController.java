package com.test.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.board.DB.TemporaryDB;
import com.test.board.model.BoardModel;

@Controller
public class BoardController {
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String goBoardList() {
		System.out.println("goBoardList()");
		return "content/board";
	}
	
	@RequestMapping(value = "/getBoardList", method = RequestMethod.POST)
	@ResponseBody
	public List<BoardModel> getBoardList() {
		System.out.println("getBoardList()");
		
		TemporaryDB db = new TemporaryDB();

		return db.getBoardList();
	}
	
	@RequestMapping(value = "/board/{board_no}", method = RequestMethod.GET)
	public ModelAndView goBoard(@PathVariable("board_no") int board_no, ModelAndView mv) {
		System.out.println("goBoard() - board_no: "+board_no);
		
		mv.addObject("board_no", board_no);
		mv.setViewName("content/board_detail");

		return mv;
	}
}
