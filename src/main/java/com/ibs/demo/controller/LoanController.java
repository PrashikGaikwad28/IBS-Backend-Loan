package com.ibs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ibs.demo.feign.AuthorizationFeign;
import com.ibs.demo.model.AppliedLoans;
import com.ibs.demo.model.LoanType;
import com.ibs.demo.service.AppliedLoanService;
import com.ibs.demo.service.LoanTypeService;
import com.ibs.demo.service.UserService;

@RestController
public class LoanController {

	@Autowired
	private LoanTypeService loanTypeService;
	
	@Autowired
	private AppliedLoanService appliedLoanService;
//	
//	@Autowired
//	private AuthorizationFeign authorizationFeign;
	
	
	@GetMapping("/getAllLoanTypes")
	public List<LoanType> getAllLoans(){
		return loanTypeService.findAll();
	}
	
	@GetMapping("/userLoan")
	public List<AppliedLoans> getAllRecords(@RequestHeader("IdToken") String bearerToken){
		return appliedLoanService.findAll(bearerToken);
	}
	
	@PostMapping("/applyLoan")
	public AppliedLoans applyLoan(@RequestHeader("IdToken") String userName, @RequestBody AppliedLoans appliedLoans) {
		return appliedLoanService.applyLoan(userName, appliedLoans);
	}
	
	@PutMapping("/updateLoan")
	public AppliedLoans updateLoan(@RequestHeader("IdToken") String userName, @RequestBody AppliedLoans appliedLoans) {
		return appliedLoanService.applyLoan(userName, appliedLoans);
	}
	
//	@GetMapping("/test")
//	public ResponseEntity<?> test(@RequestHeader("IdToken") String token) {
//		token = token.substring(7);
//		return authorizationFeign.getUser(token);
//	}
	
	
}
