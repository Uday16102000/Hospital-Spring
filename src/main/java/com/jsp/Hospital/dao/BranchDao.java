package com.jsp.Hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Hospital.dao.repository.BranchRepo;
import com.jsp.Hospital.dto.Branch;
@Repository
public class BranchDao {
	@Autowired
    private BranchRepo repo;

	public Branch saveBranch(Branch branch) {
		return repo.save(branch);
		
	}

}
