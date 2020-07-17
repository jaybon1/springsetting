package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.User;

public interface UserRepository {
	
	public User findById(int id);
	
	public List<User> findAll();
	
}