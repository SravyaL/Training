package com.Verizon.ui;

public class RegularEmployee extends Employee {
	
	public RegularEmployee() {
		super();
	}
	
	public RegularEmployee(int empID, String name, double basic) {
		super(empID, name, basic);
	}

	@Override
	public double computeHRA() {
		return getBasic()*0.12;
	}

}
