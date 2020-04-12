package com.spring.member.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.common.model.DuplicateDTO;
import com.spring.member.model.MemberDTO;
import com.spring.member.model.MemberVO;
import com.spring.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name = "memberService")
	private MemberService service;
	
	public MemberController() {
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insertUI(ModelAndView mv) {
		mv.setViewName("/member/insert/회원가입");
		return mv;
	}

	@RequestMapping(value="/insert/success", method = RequestMethod.GET )
	@ResponseBody
	public String insertSuccess() {
		StringBuffer script = new StringBuffer();
		script.append("<script type='text/javascript' ");
		script.append("src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js'>");
		script.append("</script>");
		script.append("<script type='text/javascript'>");
		script.append("$(function(){"); 
		script.append("var url = '/';"); 
		script.append("if(confirm('회원가입에 성공했습니다. 로그인 하시겠습니까?')){");
		script.append("url='/account/login';");
		script.append("}");
		script.append("location.href=url;");
		script.append("});");
		script.append("</script>"); 
		return script.toString();
	}
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public ModelAndView insert(ModelAndView mv,MemberDTO dto,MemberVO vo) {
		String viewName = "redirect:/member/insert/success";
		try {
			dto.setM_gender(vo.getGender());
			dto.setM_birth(vo.getBirth());
			dto.setM_age(vo.getAge());
			if(service.register(dto) == 0) {
				throw new Exception(); 
			}
		} catch (Exception e) {
			viewName = "redirect:/error/member/insert";
		}finally {
			mv.setViewName(viewName);
		}
		return mv;
	}
	@RequestMapping(value="/duplicate", method = RequestMethod.POST)
	@ResponseBody
	public String duplicate(String target,String value)throws Exception{
		return service.duplicate(new DuplicateDTO(target, value));
	}
}
