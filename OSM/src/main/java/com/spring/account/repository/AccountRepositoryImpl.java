package com.spring.account.repository;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {
	@Resource(name="sqlSession")
	private SqlSession sql;
	private final String ns = "com.spring.account.";
	public AccountRepositoryImpl() {
	}

	@Override
	public Integer create(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object read(Object dto) throws Exception {
		return sql.selectOne(ns+"login",dto);
	}
 
	@Override
	public List<Object> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
