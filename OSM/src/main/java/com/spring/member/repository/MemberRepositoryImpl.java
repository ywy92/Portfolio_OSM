package com.spring.member.repository;

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
	public Object create(Object dto) throws Exception {
		return null;
	}

	@Override
	public Object update(Object dto) throws Exception {
		return null;
	}

	@Override
	public Object delete(Object dto) throws Exception {
		return null;
	}

	@Override
	public Object read(Object dto) throws Exception {
		return null;
	}

	@Override
	public Object list() throws Exception {

		return null;
	}

	@Override
	public MemberDTO duplicate(DuplicateDTO dto) throws Exception {
		return sql.selectOne(ns+"duplicate", dto);
	}

}
