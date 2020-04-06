package com.spring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

	public MemberController() {
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insertUI(ModelAndView mv) {
		mv.setViewName("/member/insert/회원가입");
		return mv;
	}
}
