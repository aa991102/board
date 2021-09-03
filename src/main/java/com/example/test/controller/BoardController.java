package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dto.BoardDTO;
import com.example.test.service.BoardService;

@RestController
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	BoardService boardSVC;

	/**
	 * @Method : getBoardList
	 * @Descryption : 게시글 리스트
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @return
	 */
	@GetMapping("/getList")
	public List<BoardDTO> getBoardList() {
		return boardSVC.getBoardList();
	}
	
	/**
	 * @Method : boardDetail
	 * @Descryption : 게시글 상세
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @param board_no
	 * @return
	 */
	@GetMapping("/getDetail/{board_no}")
	public BoardDTO boardDetail(@PathVariable("board_no") int board_no) {
		BoardDTO board = boardSVC.getBoard(board_no);
		
		return board;
	}
	
	/**
	 * @Method : insertBoard
	 * @Descryption : 게시글 작성
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @param board
	 * @return
	 */
	@PostMapping("/writeBoard")
	public String insertBoard(BoardDTO board) {
		int result = boardSVC.addBoard(board);

		return result == 1 ? "success" : "fail";
	}
	
	/**
	 * @Method : updateBoard
	 * @Descryption : 게시글 수정
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @param board
	 * @return
	 */
	@PutMapping("/updateBoard")
	public String updateBoard(BoardDTO board) {
		int result = boardSVC.updateBoard(board);
		
		return result == 1 ? "success" : "fail";
	}
	
	/**
	 * @Method : updateBoardCheck
	 * @Descryption : 
	 * @Author : 오지영_
	 * @Date : 2021. 9. 3.
	 * @History :
	 * 2021. 9. 3.	오지영_	최초 작성
	 * @param board
	 * @return
	 */
	@GetMapping("/boardCheck")
	public String boardCheck(BoardDTO board) {
		boolean result = boardSVC.checkPassword(board);
		
		return result ? "success" : "fail";
	}
	
	/**
	 * @Method : deleteBoard
	 * @Descryption : 게시글 삭제
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @param board_no
	 * @return
	 */
	@DeleteMapping("/deleteBoard/{board_no}")
	public String deleteBoard(@PathVariable("board_no") int board_no) {
		int result = boardSVC.deleteBoard(board_no);
		
		return result == 1 ? "success" : "fail";
	}
}
