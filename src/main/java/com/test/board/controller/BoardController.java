package com.test.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.board.DB.TemporaryDB;
import com.test.board.dao.BoardDAO;
import com.test.board.model.BoardModel;

@Controller
public class BoardController {
	static BoardDAO boardDAO = new BoardDAO();
	
	// 게시글 리스트 - 페이지로 이동
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String goBoardList() {
		System.out.println("goBoardList()");
		return "content/list";
	}
	
	// 게시글 리스트 - 가져오기
	@RequestMapping(value = "/getBoardList", method = RequestMethod.POST)
	@ResponseBody
	public List<BoardModel> getBoardList() {
		System.out.println("getBoardList()");
		
		return boardDAO.getBoardList();
	}
	
	// 게시글 상세 - 페이지로 이동 및 상세 내용 가져오기
	@RequestMapping(value = "/board/{board_no}", method = RequestMethod.GET)
	public ModelAndView goBoard(@PathVariable("board_no") int board_no, ModelAndView mv) {
		System.out.println("goBoard() - board_no: "+board_no);
		
		BoardModel board = boardDAO.getBoard(board_no);
		
		if(board == null) {
			mv.setViewName("content/error_no_board");
		}else {
			mv.addObject("board", board);
			mv.setViewName("content/detail");
		}
		
		return mv;
	}
	
	// 게시글 작성 - 페이지로 이동
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String goBoardWrite() {
		System.out.println("goBoardWrite()");
		return "content/write";
	}
	
	// 게시글 작성 - db에 삽입
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWrite(BoardModel board) {
		System.out.println("boardWrite()");
		System.out.println(board.toString());
		boardDAO.addBoard(board);
		
		return "redirect:board";
	}
	
	// 게시글 수정 - 비밀번호 확인 페이지로 이동
	@RequestMapping(value = "/boardUpdateCheck/{board_no}", method = RequestMethod.GET)
	public ModelAndView goBoardUpdateCheck(@PathVariable(value="board_no") int board_no, ModelAndView mv) {
		System.out.println("goBoardUpdateCheck() - board_no: " + board_no);
		
		BoardModel board = boardDAO.getBoard(board_no);
		
		if(board == null) {
			mv.setViewName("content/error_no_board");
		}else {
			mv.addObject("board_no", board_no);
			mv.setViewName("content/update_check_password");
		}
		
		return mv;
	}
	
	// 게시글 수정 - 비밀번호 확인
	@RequestMapping(value = "/boardUpdateCheck", method = RequestMethod.POST)
	public String boardUpdateCheck(@RequestParam(value="board_no", defaultValue="-1") int board_no, String password) {
		System.out.println("boardUpdateCheck()");

		if(boardDAO.checkPassword(board_no, password)) { // 비밀번호가 일치하는 경우
			return "redirect:boardUpdate/"+board_no;			
		}
		
		return "content/error_password_do_not_match";
	}
	
	// 게시글 수정 - 게시글 정보 가져오는 페이지
	@RequestMapping(value = "/boardUpdate/{board_no}", method = RequestMethod.GET)
	public ModelAndView goBoardUpdate(@PathVariable(value="board_no") int board_no, ModelAndView mv) {
		System.out.println("goBoardUpdate() - board_no: " + board_no);
		
		BoardModel board = boardDAO.getBoard(board_no);
		System.out.println(board.toString());
		mv.addObject("board", board);
		mv.setViewName("content/update");
		
		return mv;
	}
	
	// 게시글 수정 - db 수정
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardModel board) {
		System.out.println("boardUpdate()");

		boardDAO.updateBoard(board);
		
		return "redirect:board";
	}
	
	// 게시글 삭제 - 비밀번호 확인 페이지로 이동
		@RequestMapping(value = "/boardDeleteCheck/{board_no}", method = RequestMethod.GET)
		public ModelAndView goBoardDeleteCheck(@PathVariable(value="board_no") int board_no, ModelAndView mv) {
			System.out.println("goBoardDeleteCheck() - board_no: " + board_no);
			
			BoardModel board = boardDAO.getBoard(board_no);
			
			if(board == null) {
				mv.setViewName("content/error_no_board");
			}else {
				mv.addObject("board_no", board_no);
				mv.setViewName("content/delete_check_password");
			}
			
			return mv;
		}
		
		// 게시글 삭제 - 비밀번호 확인
		@RequestMapping(value = "/boardDeleteCheck", method = RequestMethod.POST)
		@ResponseBody
		public String boardDeleteCheck(@RequestParam(value="board_no", defaultValue="-1") int board_no, String password) {
			System.out.println("boardDeleteCheck()");

			if(boardDAO.checkPassword(board_no, password)) { // 비밀번호가 일치하는 경우
				return "success";
			}
			
			return "fail";
		}
		
		// 게시글 삭제 - db에서 삭제
		@RequestMapping(value = "/boardDelete/{board_no}", method = RequestMethod.POST)
		@ResponseBody
		public String boardDelete(@PathVariable(value="board_no") int board_no) {
			System.out.println("boardUpdate() - board_no: "+board_no);

			int ok = boardDAO.deleteBoard(board_no);
			
			return ok==1 ? "success" : "fail";
		}
}
