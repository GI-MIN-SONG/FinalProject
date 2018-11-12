package com.tje.controller;

import com.tje.model.Member;
import com.tje.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AJAXController {
	
	@Autowired
	private MemberService service;
	
	
	@RequestMapping(value = "/ajaxTest",method=RequestMethod.GET)
	public String ajaxTestPage() {
		return "ajaxTest";
	}
	
	
	// @RequestBody은 post 방식으로 전달된 데이터를 매개변수로
	// 사용하는 경우 정의합니다.
	// 일반적으로 비동기 통신(AJAX)를 통해 전달되는 데이터를 처리할 때 사용됩니다.
	
	// @ResponseBody 로 지정하여 클라이언트에게 데이터를 전송
	@ResponseBody
	@RequestMapping(value = "/ajaxTest",method=RequestMethod.POST)
	public String ajaxTestPage(@RequestBody String strJsonData) {
		System.out.println(strJsonData);
		return "{\"msg\": \"Hello AJAX\"}";
	}
	
	@RequestMapping(value = "/member/regist",method=RequestMethod.GET)
	public String memberRegistpage() {
		return "/member/registForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/checkId/{id}",method=RequestMethod.POST)
	public String checkId(@PathVariable("id") String member_id) {
		System.out.println(member_id);
		
		Member member = new Member();
		member.setId(member_id);
		
		Member result = service.selectOne(member);
		String msg;
		if (result == null)
			msg = "사용 가능한 ID 입니다.";
		else
			msg = "이미 사용중인 ID 입니다.";
		
		
		return "{\"value\": \""+msg+"\"}";
	}

}
