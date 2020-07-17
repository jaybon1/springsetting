package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.Account;

public interface AccountRepository { 
	
	// 서비스가 아니라 가장 기본적인 crud를 만들어야 한다 
	// 이것을 조합하여 서비스를 만들자
	
	// 추상클래스
	// xml 매핑파일과 연결
	public void update(Account account); // 객체를 넘겨서 처리하자 
	
	public List<Account> findAll();
	
	public Account findByAccountNumber(String accountNumber);
	
}