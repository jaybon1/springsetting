package com.cos.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Controller
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping({"", "/"})
	public String index() {
		
		return "index";
	}
	
	
	@GetMapping("/user/{id}")
	public @ResponseBody User findById(@PathVariable int id) {
		
		User user = userRepository.findById(id);
		
		return user;
	}
	
	
	@GetMapping("/user")
	public @ResponseBody List<User> findAll() {
		
		List<User> userList = userRepository.findAll();
		
		return userList;
	}
}
