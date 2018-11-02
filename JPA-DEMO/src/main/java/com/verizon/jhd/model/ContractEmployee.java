package com.verizon.jhd.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cemp")
public class ContractEmployee extends Employee {
	@Column(name="cdur")
	private int contactDuration;
	
	public ContractEmployee(){
		
	}

	public ContractEmployee(int contactDuration) {
		super();
		this.contactDuration = contactDuration;
	}

	public int getContactDuration() {
		return contactDuration;
	}

	public void setContactDuration(int contactDuration) {
		this.contactDuration = contactDuration;
	}
	
	
}
