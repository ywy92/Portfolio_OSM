package com.spring.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.common.model.DuplicateDTO;
import com.spring.member.model.MemberDTO;
import com.spring.member.repository.MemberRepository;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Resource(name="memberRepository")
	private MemberRepository repository;
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer register(Object dto) throws Exception {
		return repository.create(dto);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String duplicate(DuplicateDTO dto) throws Exception {
		return repository.duplicate(dto) == null? "success":"fail";
	}

}
