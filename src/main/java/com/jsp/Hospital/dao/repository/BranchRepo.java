package com.jsp.Hospital.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Hospital.dto.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {

}
