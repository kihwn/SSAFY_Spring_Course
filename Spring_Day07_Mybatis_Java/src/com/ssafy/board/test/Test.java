package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyBatisConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[]args) {
		
		
//		MyBatisConfig.getFactory();
		//전체 조회
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
//			List<Board>boards = session.selectList("com.ssafy.board.model.dao.BoadDao.selectAll");			
//				for (Board board : boards){
//					System.out.println(board);
//					}
//			}
//		
//		//상세 게시글 조회!
//		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
//			BoardDao dao = session.getMapper(BoardDao.class);
//			Board board = dao.selectOne(1);
//			System.out.println(board);
//		}
//		
		//게시글 등록
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = new Board("Spring 공부","혜원","열심히하자!");
			dao.insertBoard(board);
		}
		
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
			List<Board>boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for (Board board:boards) {
				System.out.println(board);
			}
		}
		
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)){
			BoardDao dao = session.getMapper(BoardDao.class);
			dao.deleteBoard(3);
		}
//		
		try(SqlSession session=MyBatisConfig.getFactory().openSession(true)){
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = dao.selectOne(1);
			board.setTitle("더더 화이팅");
			dao.updateBoard(board);
		}
		
		
		
		}
	}

	

