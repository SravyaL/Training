package com.verizon.employee.model;

public class Employee {
	public int eid;
	public String ename;
	public double basic;
	public double hra;
	public String dept;
	
	public Employee(){}
	

	public Employee(int eid, String ename, double basic, double hra, String dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.basic = basic;
		this.hra = hra;
		this.dept = dept;
	}


	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}