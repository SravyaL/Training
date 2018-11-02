package com.verizon.jhd.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("memp")
public class Manager extends Employee {
	
	private double allowance;
	
	public Manager(){}

	public Manager(int empId, String ename, double basic,double allowance) {
		super(empId,ename,basic);
		this.allowance = allowance;
	}
	
	
	

}
