package com.verizon.service;

public class SimpleTest implements welcomeService {
	
	private String greeting;
	public SimpleTest(){
		
	}
	public SimpleTest(String greeting) {
		super();
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String greetUser(String userName) {
		// TODO Auto-generated method stub
		return greeting + " " + userName;
	}

}
