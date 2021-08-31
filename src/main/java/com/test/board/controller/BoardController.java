package com.test.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.board.DB.TemporaryDB;
import com.test.board.model.BoardModel;

@Controller
public class BoardController {
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String goBoardList(HttpServletRequest request, ModelAndView mv) {
		System.out.println("goBoardList()");
		return "content/board";
	}
	
	@RequestMapping(value="/getBoardList", method=RequestMethod.POST)
	@ResponseBody
	public List<BoardModel> getBoardList(HttpServletRequest request, ModelAndView mv) {
		System.out.println("getBoardList()");
		
		TemporaryDB db = new TemporaryDB();

		return db.getBoardList();
	}
	
	@RequestMapping(value="/board", method=RequestMethod.POST)
	@ResponseBody
	public List<BoardModel> getBoard(HttpServletRequest request, ModelAndView mv) {
		System.out.println("getBoardList()");
		
		TemporaryDB db = new TemporaryDB();

		return db.getBoardList();
	}
}
