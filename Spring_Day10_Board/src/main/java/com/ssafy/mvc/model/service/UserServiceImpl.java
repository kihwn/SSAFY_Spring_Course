package com.ssafy.mvc.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;
@Service
public class UserServiceImpl implements UserService{
	
	private final UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String id, String password) {
		Map<String, String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		User tmp = userDao.selectOne(info);
		
		return tmp;
	}

}
