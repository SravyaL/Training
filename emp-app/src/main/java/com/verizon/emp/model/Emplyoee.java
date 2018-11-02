package com.verizon.emp.model;

public class Emplyoee {
	public int empId;
	public String ename;
	public double basic;
	public double hra;
	public String dept;
	
	public Emplyoee(){}

	public Emplyoee(int empId, String ename, double basic, double hra, String dept) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.basic = basic;
		this.hra = hra;
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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
