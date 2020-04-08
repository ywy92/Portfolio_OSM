package com.spring.member.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.common.model.DuplicateDTO;
import com.spring.common.model.TargetAndValueDTO;
import com.spring.member.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name = "memberService")
	private MemberServiceImpl service;
	
	public MemberController() {
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insertUI(ModelAndView mv) {
		mv.setViewName("/member/insert/회원가입");
		return mv;
	}
	
	@RequestMapping(value="/duplicate", method = RequestMethod.POST)
	@ResponseBody
	public String duplicate(String target,String value)throws Exception{
		return service.duplicate(new DuplicateDTO(target, value));
	}
}
