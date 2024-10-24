package com.ssafy.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest4")
public class RestController4 {
	//ex ) http://localhost:8080/rest4/board/1
	//ex ) http://localhost:8080/rest4/board/2
	//ex ) http://localhost:8080/rest4/board/99
	
	@GetMapping("/board1/{id}") 
	public String test1(@PathVariable int id) {
		return id+":board";
	}
	
	@GetMapping("/board2/{id}") //이름으로 id 그대로 넣고 싶을 때~
	public String test2(@PathVariable("id") int num) {
		return num+":board";
	}

}
