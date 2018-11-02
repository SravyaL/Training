package com.verizon.jhd.model.association;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bankaccounts")
public class BankAccount {
	@Id
	private String accNo;
	private double bal;
	
	@OneToOne
	@JoinColumn(name="accHolderId")
	private Citizen accountHolder;

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public Citizen getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Citizen accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	
	
}
