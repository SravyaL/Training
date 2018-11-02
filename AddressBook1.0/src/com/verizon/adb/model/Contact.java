package com.verizon.adb.model;

import java.io.Serializable;

public class Contact implements Serializable{
	
	private String name;
	private String mobileNumber;
	private String email;
	
	public Contact(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	
	
}
