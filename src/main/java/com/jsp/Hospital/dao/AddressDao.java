package com.jsp.Hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Hospital.dao.repository.AddressRepo;
import com.jsp.Hospital.dto.Address;

@Repository
public class AddressDao {

	@Autowired
 private 	AddressRepo repo;
	public Address saveAddress(Address address) {
	   return repo.save(address);
	}
	public Address updateAddress(int id, Address address) {
		Optional<Address> optional= repo.findById(id);
		if(optional.isPresent())
		{
			address.setAddressId(id);
			repo.save(address);
			return address;
		}
		return null;
		
	}
	public Address getAddress(int id) {
	Optional<Address> address= repo.findById(id);
	return address.get();
	}
	public Address deleteAddress(int id) {
		Address address= repo.findById(id).get();
		repo.delete(address);
		return address;
	}
	public Address findAddressById(int addressId) {
		// TODO Auto-generated method stub
		Optional<Address> address= repo.findById(addressId);
		if(address!=null)
		{
			return address.get();
		}else {
		return null;
		}
	}

}
