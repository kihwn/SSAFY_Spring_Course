package com.ssafy.mvc.model;

import java.util.List;

public interface BoardService {
	
	public List<Board> getBoardList();
	
	public Board readBoard(int id);
	
	public void writeBoard(Board board);
	
	public removeBoard(int id);
	
	public void modifyBoard(Board board);

}
