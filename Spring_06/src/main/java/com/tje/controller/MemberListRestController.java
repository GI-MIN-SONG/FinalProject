package com.tje.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tje.model.Member;
import com.tje.service.MemberService;



// @RestController에 적용된 클래스 내부의 모든 메소드가
// @ResponseBody 이 자동으로 적용됩니다.
// AJAX와 같은 비동기 통신을 위해서 사용되는 클래스를 정의할 때
// @Requst
@RestController
public class MemberListRestController {
	
	@Autowired
	private MemberService service;
	
		// ResponseBody를 생략해도 됨
		@RequestMapping(value="member/list", method=RequestMethod.POST)
		public String memberListForm() {
			
			List<Member> list = service.selectList();
			
			
			Gson gson = new Gson();
			String json = gson.toJson(list);
			
			System.out.println(json);
			return json;
		}

}
