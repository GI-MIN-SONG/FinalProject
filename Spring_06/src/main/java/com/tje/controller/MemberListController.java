package com.tje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberListController {
	
	@RequestMapping(value="member/list", method=RequestMethod.GET)
	public String memberListForm() {
		return "/member/list";
	}
	
	

}
