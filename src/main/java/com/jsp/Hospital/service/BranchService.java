package com.jsp.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.Hospital.dao.AddressDao;
import com.jsp.Hospital.dao.BranchDao;
import com.jsp.Hospital.dao.HospitalDao;
import com.jsp.Hospital.dto.Address;
import com.jsp.Hospital.dto.Branch;
import com.jsp.Hospital.dto.Hospital;
import com.jsp.Hospital.exception.AddressIdNotFoundException;
import com.jsp.Hospital.exception.HospitalIdNotFoundException;
import com.jsp.Hospital.util.ResponseStructure;
@Service
public class BranchService {
    @Autowired
    private HospitalDao hospitaldao;
    @Autowired
    private AddressDao addressdao;
    
    @Autowired
    private BranchDao branchdao;



	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hospitalid, int addressId, Branch branch) {
	Hospital hospital=hospitaldao.findHospitalById(hospitalid);
	if(hospital!=null)
	{
		Address address=addressdao.findAddressById(addressId);
		if(address!=null) {
			 branch.setHospital(hospital);
			 branch.setAddress(address);
			 Branch db =branchdao.saveBranch(branch);
			 
			 ResponseStructure<Branch> structure= new ResponseStructure<Branch>();
			 
			 structure.setMessage("Branch saved Successfully");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(db);
	return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
		}else {
			throw new AddressIdNotFoundException("sorry addreess id not found");
		}
		
	} else {
		throw new HospitalIdNotFoundException("sorry hospital id not found");
	}
	}
}
