package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.SendRequestDto;
import com.cos.blog.dto.WithdrawRequestDto;
import com.cos.blog.model.Account;
import com.cos.blog.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository; // DI
	
	
	// 트랜잭셔널을 쓰면 롤백과 커밋 등 트랜잭션관리가 자동으로 된다
	@Transactional
	public void 송금(SendRequestDto sendRequestDto) {
		
		// 홍길동 업데이트
		Account 보내는사람 = accountRepository.findByAccountNumber(sendRequestDto.getSenderAccountNumber());
		보내는사람.setMoney(보내는사람.getMoney() - sendRequestDto.getMoney());
		accountRepository.update(보내는사람);
		
		// 장보고 업데이트
		Account 받는사람 = accountRepository.findByAccountNumber(sendRequestDto.getReceiverAccountNumber());
		받는사람.setMoney(받는사람.getMoney() + sendRequestDto.getMoney());
		accountRepository.update(받는사람);
		
	}
	
	
	@Transactional
	public void 인출(WithdrawRequestDto withdrawRequestDto) {
		
		Account 인출하는사람 = accountRepository.findByAccountNumber(withdrawRequestDto.getAccountNumber());
		인출하는사람.setMoney(인출하는사람.getMoney() - withdrawRequestDto.getMoney());
		accountRepository.update(인출하는사람);
		
	}
	
	
	// 쿼리가 하나 뿐인데도 트랜잭셔널 적는이유 독립성(고립성)
	@Transactional(readOnly = true)
	public List<Account> 계좌정보보기() {
		return accountRepository.findAll();
	}

}
