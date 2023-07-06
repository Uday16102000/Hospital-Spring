package com.jsp.Hospital.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital 
{
	@Id
private int id;
private String name;
private String ceo;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Hospital [id=" + id + ", name=" + name + ", ceo=" + ceo + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCeo() {
	return ceo;
}
public void setCeo(String ceo) {
	this.ceo = ceo;
}


}
