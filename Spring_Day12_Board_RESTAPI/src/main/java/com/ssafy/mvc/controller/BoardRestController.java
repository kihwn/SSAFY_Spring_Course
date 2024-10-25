package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

@RestController
@RequestMapping("/api-board")
//이 실습에선 여러 가지 방법을 알려주시느라 방법이 통일되지 않음. 실제로 내가 구현할 땐 방법 통일하기. 
public class BoardRestController {
	//서비스 의존성 주입
	private final BoardService boardService;

	@Autowired
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//게시글 전체 조회
	@GetMapping("/board")
	public ResponseEntity<List<Board>>list(){
		List<Board>list = boardService.getBoardList();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	//게시글 상세 보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id){
		Board board = boardService.readBoard(id);
		//System.out.println(board);
		if (board!=null) {
			return ResponseEntity.ok(board);}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//게시글 등록 (Form 데이터 형식으로 넘어 왔다고 가정)
	//board 자체를 넘기기 보다는 id같은 것을 넘겨서 
	//프론트에서 detail로 요청을 보내게끔 만들면 좋겠는데 ..
	@PostMapping("/board")
	public ResponseEntity<?>write(@ModelAttribute Board board){
		boardService.writeBoard(board);
		System.out.println(board);
		int id = board.getId(); 
		//파라미터로 들어온 board 자체를 반환함. 의미가 있나?
		return new ResponseEntity<Board>(board,HttpStatus.CREATED);
	}
	
	//게시글 삭제 
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		boolean isDeleted = boardService.removeBoard(id);
		if (isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	
	//게시글 수정
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id")int id, @RequestBody Board board){
		board.setId(id); //만약 넘겨온 파라미터의 id가 비어있다면 직접 id 넘겨 받은 것을 넣을 수 있음.
		boardService.modifyBoard(board);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
