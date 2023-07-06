package com.jsp.Hospital.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Hospital.dao.repository.HospitalRepo;
import com.jsp.Hospital.dto.Hospital;

@Repository
public class HospitalDao {
@Autowired
private HospitalRepo repo;
	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);

		// TODO Auto-generated method stub
		
	}
	public Hospital getHospitalById(int id) {
		Optional<Hospital> hospital=repo.findById(id);
		
		return hospital.get();
	
	}
	public Hospital updateHospital(int id, Hospital hospital) {
		// TODO Auto-generated method stub
		Optional<Hospital> dbhospital=repo.findById(id);
		if(dbhospital.isPresent())
		{
			hospital.setId(id);
			repo.save(hospital);
			return hospital;
		}
		return null;
	}
	public Hospital deleteHospital(int id) {
		// TODO Auto-generated method stub
	Optional<Hospital> hospital= repo.findById(id);
	if(hospital.isPresent())
	{
		repo.delete(hospital.get());
		return hospital.get();
	}
	return null;
	
	}

}
