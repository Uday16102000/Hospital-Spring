package com.jsp.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Hospital.dao.AddressDao;
import com.jsp.Hospital.dto.Address;
import com.jsp.Hospital.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		
		Address addressdb= dao.saveAddress(address);
		ResponseStructure<Address> structure= new ResponseStructure<Address>();
		structure.setMessage("Address saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(addressdb);
		
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	
		
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		
		Address dbaddress= dao.updateAddress(id,address);
		ResponseStructure<Address> structure= new ResponseStructure<Address>();
		structure.setMessage("Address updated successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dbaddress);
		
		 return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Address>> getAddress(int id) {
		
		Address address= dao.getAddress(id);
		
		ResponseStructure<Address> structure= new ResponseStructure<Address>();
		structure.setMessage("Address fetched successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(address);
		
		 return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		
		Address address= dao.deleteAddress(id);

		ResponseStructure<Address> structure= new ResponseStructure<Address>();
		structure.setMessage("Address deleted successfully");
		structure.setStatus(HttpStatus.NO_CONTENT.value());
		structure.setData(address);
		
		 return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.NO_CONTENT);
		// TODO Auto-generated method stub
	
	}

}
