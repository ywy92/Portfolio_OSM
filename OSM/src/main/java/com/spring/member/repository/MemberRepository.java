package com.spring.member.repository;

import com.spring.common.model.DuplicateDTO;
import com.spring.member.model.MemberDTO;
import com.spring.repository.RepositoryInterface;

public interface MemberRepository extends RepositoryInterface {
	public abstract MemberDTO duplicate(DuplicateDTO dto)throws Exception;
}
