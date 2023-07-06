package com.jsp.Hospital.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Branch {
	@Id
	private int branchId;
	private String nameOfBranch;
@OneToOne	
private Address address;
@ManyToOne
private Hospital hospital;

public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}
public String getNameOfBranch() {
	return nameOfBranch;
}
public void setNameOfBranch(String nameOfBranch) {
	this.nameOfBranch = nameOfBranch;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public Hospital getHospital() {
	return hospital;
}
public void setHospital(Hospital hospital) {
	this.hospital = hospital;
}
@Override
public String toString() {
	return "Branch [branchId=" + branchId + ", nameOfBranch=" + nameOfBranch + ", address=" + address + ", hospital="
			+ hospital + "]";
}

	
	

}
