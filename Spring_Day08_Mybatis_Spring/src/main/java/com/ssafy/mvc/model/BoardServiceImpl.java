package com.ssafy.mvc.model;

import java.util.List;

public class BoardServiceImpl implements BoardService{

	private final BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	
	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id+"번 글을 읽어옵니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성했습니다.");
		boardDao.insertBoard(board);
		
	}

	@Override
	public void removeBoard(int id) {
		System.out.println("게시글 삭제합니다.");
		boardDao.deleteBoard(id);
		
	}

	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글을 수정합니다.");
		boardDao.updateBoard(board);
		
	}
	

}
