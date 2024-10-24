package com.ssafy.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest2")
public class RestController2 {
	
	@GetMapping("/test1")
	public String test1() {
		return "Hello REST API";
	}

}
