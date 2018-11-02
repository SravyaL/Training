package com.verizon.jhd.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.verizon.jhd.model.composition.Address;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="etype",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("emp")
@Table(name="AllEmps")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	@Column(name="ename",nullable=false)
	private String empName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name="dob")
	private LocalDate dateOfBirth;
	@Embedded
	private Address address;
	
	public Employee(){
		
	}

	public Employee(String empName, Gender gender, LocalDate dateOfBirth, Address address) {
		super();
		
		this.empName = empName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
