package com.ssafy.mvc.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;

@RestController
@RequestMapping("/rest5")
public class RestController5 {
	//form 데이터 형식으로 요청을 보낼 때 (이젠 안씀!)
	@PostMapping("/board1")
	public String test1(@ModelAttribute User user) {
		return user.toString();
	}
	
	//이젠 json 형식으로 보내고 싶을 땐 @ModelAttribute 대신 @RequestBody를 쓰자
	@PostMapping("/board2")
	public String test2(@RequestBody User user) {
		return user.toString();
	}

}
