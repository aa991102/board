package com.example.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.BoardDAO;
import com.example.test.dto.BoardDTO;

@Service
public class BoardService {
	@Autowired
	BoardDAO boardDAO;
	
	/**
	 * @Method : getBoardList
	 * @Descryption : 게시글 리스트
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @return
	 */
	public List<BoardDTO> getBoardList(){
		return boardDAO.selectBoards();
	}
	
	/**
	 * @Method : getBoard
	 * @Descryption : 게시글 상세
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @param board_no
	 * @return
	 */
	public BoardDTO getBoard(int board_no) {
		return boardDAO.selectBoard(board_no);
	}
	
	/**
	 * @Method : addBoard
	 * @Descryption : 게시글 삽입(생성)
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @param board
	 * @return
	 */
	public int addBoard(BoardDTO board) {
		return boardDAO.insertBoard(board);
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
	public int updateBoard(BoardDTO board) {
		return boardDAO.updateBoard(board);
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
	public int deleteBoard(int board_no) {
		return boardDAO.deleteBoard(board_no);
	}
	
	/**
	 * @Method : checkPassword
	 * @Descryption : 게시글 번호에 해당 게시글의 비밀번호가 일치하는지 확인
	 * @Author : 오지영_
	 * @Date : 2021. 9. 2.
	 * @History :
	 * 2021. 9. 2.	오지영_	최초 작성
	 * @param board_no
	 * @param password
	 * @return
	 */
	public boolean checkPassword(BoardDTO board) {
		int result = boardDAO.selectCountByBoardNoAndPassword(board);
		
		return result == 1? true : false;
	}
}
