package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	

	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		//원래는 UserService를 통해서 로그인 하는 것이 맞지만,
		//지금은 id : abc이고 pw:1234일 때 통과하도록 하자
		//원래는 user 객체가 null이 아니란 것을 확인하고 사용해야 함. 
		if (user.getId().equals("abc") && user.getPw().equals("1234")) {
			//이건 통과
			session.setAttribute("loginUser", user.getId());
			return "redirect:hello";
		}
		// 로그인 실패했을 경우 !
		return "redirect:login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//로그아웃을 하는 방법 2가지!
		//1. 세션에서 유저 속성을 지우는 작업
//		session.removeAttribute("loginUser");
		//2. 세션 자체를 초기화
		session.invalidate(); 
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
