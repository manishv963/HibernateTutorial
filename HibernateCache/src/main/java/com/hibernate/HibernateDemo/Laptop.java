package com.hibernate.HibernateDemo;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage=CacheConcurrencyStrategy.READ_WRITE)

public class Laptop {
	@Id
	private int lid;
	private String lname;
	
	@ManyToMany()
	private List<Student> student= new ArrayList<Student>();;
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
}
