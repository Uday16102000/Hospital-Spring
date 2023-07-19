package com.jsp.Hospital.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.Hospital.dto.Hospital;

public interface HospitalRepo  extends JpaRepository<Hospital, Integer>{
   @Query("select h from Hospital h where h.name=?1")
	public Hospital fetchHospitalByName(String name);

}
