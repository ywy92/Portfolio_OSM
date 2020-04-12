package com.spring.account.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.account.service.AccountService;
import com.spring.member.model.MemberDTO;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Resource(name = "accountService")
	private AccountService service;

	public AccountController() {
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mv,MemberDTO dto,String autoLoginCheck) {
		String m_id = dto.getM_id();
		String viewName = null;
		try {
			Object obj = service.getOne(dto);
			dto = obj instanceof MemberDTO ?(MemberDTO)obj:null; 
			if(dto == null) {
				throw new Exception();
			}
			mv.addObject("dto",dto); 
			mv.addObject("autoLoginCheck", autoLoginCheck);
			viewName = "redirect:/";
		}catch (Exception e) {
			mv.addObject("msg","아이디와 비밀번호를 확인해주세요.");
			mv.addObject("m_id", m_id);
			viewName = "/account/login/로그인";
		}finally {
			mv.setViewName(viewName);
		}
		return mv;
	}
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView loginUI(ModelAndView mv) {
		mv.setViewName("/account/login/로그인"); 
		return mv;
	}
}
