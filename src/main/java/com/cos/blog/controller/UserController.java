package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.model.User;

@Controller
public class UserController {
	
	// 응답을 data로 받기위해서 responsebody 추가
	// (User user)를 이용하면 xxx-form-urlencoded 만 받아진다
	// (@RequestBody User user)를 이용하면 
	// jwt 등 공부하기
	
	@PostMapping("/auth/joinProc")
	public @ResponseBody User joinProc(@RequestBody User user) {
		return user;
	}
	
}
