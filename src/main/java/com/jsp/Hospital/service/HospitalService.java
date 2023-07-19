package com.jsp.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Hospital.dao.HospitalDao;
import com.jsp.Hospital.dto.Hospital;
import com.jsp.Hospital.exception.IdNotFoundException;
import com.jsp.Hospital.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
private HospitalDao dao;
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		Hospital dbHospital=dao.saveHospital(hospital);
		ResponseStructure<Hospital> structure= new ResponseStructure<Hospital>();
		structure.setMessage("Hospital saved succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dbHospital);
	return  new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(int id) {
		// TODO Auto-generated method stub
		Hospital dbHospital= dao.getHospitalById(id);
		ResponseStructure<Hospital> structure= new ResponseStructure<Hospital>();
		structure.setMessage("Hospital fetched succesfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dbHospital);
		return new  ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		// TODO Auto-generated method stub
		Hospital dbhospital= dao.updateHospital(id,hospital);
		ResponseStructure<Hospital> structure= new ResponseStructure<Hospital>();
		structure.setMessage("Hospital updated succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dbhospital);
		
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		
		Hospital hospital=dao.deleteHospital(id);
		if(hospital!=null){
		ResponseStructure<Hospital> structure= new ResponseStructure<Hospital>();
		structure.setMessage("Hospital deleted successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(hospital);
		return  new ResponseEntity<ResponseStructure<Hospital>> (structure,HttpStatus.FOUND);
		}else {
//			throw new IdNotFoundException("Sorry failed to delete");
			throw new IdNotFoundException("Sorry not deleted because value is null");
		}
	}
	public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalByName(String name) {
	Hospital hospital=dao.fetchHospitalByName(name);
	ResponseStructure<Hospital> structure= new ResponseStructure<Hospital>();
	
	structure.setMessage("Fetched successfully by name");
	structure.setStatus(HttpStatus.FOUND.value());
	structure.setData(hospital);
	return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
	
	}

}
