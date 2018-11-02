package com.Verizon.ui;

public abstract class Employee {
	private int empID;
	private String name;
	private double basic;
	
	public Employee()
	{
		
	}
	public Employee(int empID, String name, double basic) {
		//super();
		this.empID = empID;
		this.name = name;
		this.basic = basic;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	public abstract double computeHRA();
	
	public double computeNetPay(){
		return basic+ computeHRA();
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", basic=" + basic + ", computeHRA()=" + computeHRA()
				+ ", computeNetPay()=" + computeNetPay() + "]";
	}
	
	
	
}
