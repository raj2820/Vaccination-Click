package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Member;
import com.masai.service.MemberService;

@RestController
public class MemberController {
	

	@Autowired
	private MemberService ms;
	
	@PostMapping("/members")
	public ResponseEntity<Member> registerMember(@RequestBody Member member ,@RequestParam("phone") Long phone){
		
		Member m =	ms.addMember(member,phone);
			
		return new ResponseEntity<Member>(m,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/memberById/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable("id") Integer id){
		
		Member m=ms.getMemberById(id);
		
		return new ResponseEntity<Member>(m,HttpStatus.OK);
		
	}

	@GetMapping("/memberByAdhar/{adharNo}")
	public ResponseEntity<Member> getMemberByAdhar(@PathVariable("adharNo") Long adhar){
		
		Member m=ms.getMemberByAdharNo(adhar);
		
		return new ResponseEntity<Member>(m,HttpStatus.OK);
		
	}
	@GetMapping("/memberByPan/{panNo}")
	public ResponseEntity<Member> getMemberByPan(@PathVariable("panNo") String pan){
		
		Member m=ms.getMemberByPanNo(pan);
		
		return new ResponseEntity<Member>(m,HttpStatus.OK);
		
	}
	

	
}
