package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private final UserService userService;
	
	//@Autowired 없어도 됨
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user,HttpSession session) {
		User tmp = userService.login(user.getId(),user.getPassword()); //패스워드에 대한 정보를 빼놔야 함(보안 상)
		//tmp : 정상 로그인 -> 로그인 한 User 정보
			// 비정상 로그인 -> null
		
		if (tmp ==null) {
			return "redirect:login"; //get 방식
		}
		session.setAttribute("loginUser", tmp.getName()); //헤더에 loginUser라고 보내놨기 때문에 loginUser로 연결
		return "redirect:list";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:list";
	}
	
	
	//회원가입 -> 실습 시간에 만들어 볼 것
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList",userService.getUserList());
		return "/user/adminPage";
		
	}

}
