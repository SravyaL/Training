package com.Verizon.ui;

public class ContractEmployee extends Employee {

	@Override
	public double computeHRA() {
		// TODO Auto-generated method stub
		return getBasic()*0.34;
	}

}
