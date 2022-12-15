package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Member;
import com.masai.service.MemberService;

@RestController
public class MemberController {
	
		@Autowired
		private MemberService ms;
		
		@PostMapping("/members")
		public ResponseEntity<Member> registerMember(@RequestBody Member member){
			
			Member m =	ms.addMember(member);
				
			return new ResponseEntity<Member>(m,HttpStatus.CREATED);
		
		}
}
