package com.jsp.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Hospital.dto.Branch;
import com.jsp.Hospital.service.BranchService;
import com.jsp.Hospital.util.ResponseStructure;
@RestController
public class BranchController {
	
	@Autowired
	private  BranchService service;
	@PostMapping("/savebranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestParam int hospitalid, @RequestParam int addressId,@RequestBody Branch branch)
	{
		return service.saveBranch(hospitalid,addressId,branch);
	}
}
