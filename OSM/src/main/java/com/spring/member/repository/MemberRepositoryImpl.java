package com.spring.member.repository;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.common.model.DuplicateDTO;
import com.spring.member.model.MemberDTO;

@Repository("memberRepository")
public class MemberRepositoryImpl implements MemberRepository {
	@Resource(name = "sqlSession")
	private SqlSession sql;
	private final String ns = "com.spring.member.";

	public MemberRepositoryImpl() {
	}

	@Override
	public Integer create(Object dto) throws Exception {
		return sql.insert(ns+"insert",dto); 
	} 

	@Override
	public Integer update(Object dto) throws Exception {
		return null;
	}

	@Override
	public Integer delete(Object dto) throws Exception {
		return null;
	}

	@Override
	public Object read(Object dto) throws Exception {
		return null;
	}

	@Override
	public List<Object> list() throws Exception {

		return null;
	}

	@Override
	public MemberDTO duplicate(DuplicateDTO dto) throws Exception {
		return sql.selectOne(ns+"duplicate", dto);
	}

}
