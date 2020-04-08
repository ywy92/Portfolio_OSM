package com.spring.member.service;

import com.spring.common.model.DuplicateDTO;
import com.spring.service.ServiceInterface;

public interface MemberService extends ServiceInterface{
	public abstract String duplicate(DuplicateDTO dto) throws Exception;
}
