package com.spring.account.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.account.repository.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Resource(name = "accountRepository")
	private AccountRepository repository;
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer register(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modify(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer remove(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getOne(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> listAll() throws Exception {
		return null;
	}

}
