package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.mvc.model.dto.User;

@Controller
public class RestController1 {
	
	
	//반환타입이 문자열이라면 .. 뷰 리졸버가 -> Hello REST API.jsp를 찾는다 ..
	//404 에러 발생 -> "Hello REST API라는 이름의 jsp가 없기 때문.
	@GetMapping("/rest1/test1")
	public String test1() {
		return "Hello REST API";
	}
	
	
	//200 결과가 나오며 정상 수행 -> @ResponseBody
	@GetMapping("/rest1/test2")
	@ResponseBody
	public String test2() {
		return "Hello REST API";
	}
	
	@GetMapping("/rest1/test3")
	@ResponseBody
	public Map<String, String>test3(){
		Map<String, String> data= new HashMap<>();
		data.put("id", "ssafy");
		data.put("pw", "1234");
		return data;
		
		//맵 객체를 반환했지만, 정작 넘어간 것은 Json 형태의 data임.
		//Jackson Databind가 이를 도와줌. @RESTAPI를 사용하면 JacksonDatabind를 자연스레 사용할 수 있는듯?!
	}
	
	
	//꼭 맵으로 데이터를 전달하지 않아도 됨 . dto 모델 사용하면 돼~
	@GetMapping("/rest1/test4")
	@ResponseBody
	public User test4() {
		User user = new User("ssafy","1234","김냥뭉");
		return user;
	}
	
	@GetMapping("/rest1/test5")
	@ResponseBody
	public List<User>test5(){
		List<User> list= new ArrayList<>();
		list.add(new User("ssafy1","1234","김뭉"));
		list.add(new User("ssafy2","1234","박뭉"));
		list.add(new User("ssafy3","1234","이뭉"));
		list.add(new User("ssafy4","1234","송뭉"));
		list.add(new User("ssafy5","1234","강뭉"));
		
		return list;
	}


}
