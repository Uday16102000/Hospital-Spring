package com.jsp.Hospital.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Hospital.dto.Hospital;

public interface HospitalRepo  extends JpaRepository<Hospital, Integer>{

}
