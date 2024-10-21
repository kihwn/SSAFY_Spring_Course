package com.ssafy.mvc.Contorller
;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.BoardService;

@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/list")
	public String list(Model model) {
		//서비스를 통해서 .. 게시글들을 가져와야 한다.
		return "/board/list";
	}
	
	@GetMapping("/writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("/write")
	public String wirte(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board",board);
		
		return "/board/detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id")int id) {
		boardService.removeBoard(id);
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public String updateform(@RequestParam("id")int id,Model model) {
		//게시글을 하나 가지고 와서 updateform으로 넘겨야 된다.
		//지금은 readBoard 박에 없어서 이걸로 하긴 하지만, 이걸로 하면 게시글 조회수가 하나 올라감. 
		model.addAttribute("board",boardService.readBoard(id));
		// 그냥 쌩 게시글 하나 가져 오는 것을 고민할 필요가 있다. 
		return "/board/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id="+board.getId();
	}
}
