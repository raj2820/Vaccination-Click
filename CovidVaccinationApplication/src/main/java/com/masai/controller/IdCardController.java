package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.masai.model.IdCard;
import com.masai.service.IdCardService;

@RestController
public class IdCardController {
	
	@Autowired
	private IdCardService idCardService;
	
	
	@GetMapping("/getpancard")
	public ResponseEntity<IdCard> getPanCardByNumberHandler(@RequestParam String panNo){
		
		IdCard idCard = idCardService.getPanCardByNumber(panNo);
		
		return new ResponseEntity<IdCard>(idCard,HttpStatus.OK);
	}
	
//	@GetMapping("/getaddhar")
//    public ResponseEntity<IdCard> getAadharCardNumberHandler(@RequestParam Long aadharNo) {
//    	
//        IdCard idCard = idCardService.getAadharCardNumber(aadharNo);
//		
//		return new ResponseEntity<IdCard>(idCard,HttpStatus.OK);
//		
//    }
	
	
	@PostMapping("/addcard")
	public ResponseEntity<IdCard> addIdCardHandler(@RequestBody IdCard idCard){
		IdCard newCard =  idCardService.addIdCard(idCard);
		
		return new ResponseEntity<IdCard>(newCard,HttpStatus.CREATED);
	}


}
