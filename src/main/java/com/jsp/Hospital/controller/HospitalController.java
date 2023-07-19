package com.jsp.Hospital.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Hospital.dto.Hospital;
import com.jsp.Hospital.service.HospitalService;
import com.jsp.Hospital.util.ResponseStructure;

@RestController
public class HospitalController {
	@Autowired
	private HospitalService service;
	@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody @Valid Hospital hospital){
		return service.saveHospital(hospital);
		
	}
	
	@GetMapping("/getHospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(@RequestParam int id)
	{
		return service.getHospital(id);
	}
    
	@PutMapping("/updateHospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id, @RequestBody Hospital hospital)
	{
		return service.updateHospital(id,hospital);
		
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id){
		return service.deleteHospital(id);
	}
	@GetMapping("/fetchByName")
	public ResponseEntity<ResponseStructure<Hospital>>  fetchHospitalByName(@RequestParam String name){ 
		return service.fetchHospitalByName(name);
	}
}
