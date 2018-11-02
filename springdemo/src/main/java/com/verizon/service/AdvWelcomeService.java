package com.verizon.service;

public class AdvWelcomeService implements welcomeService {
	private GreetingProvider greetingProvider;
	
	public GreetingProvider getGreetingProvider() {
		return greetingProvider;
	}

	public void setGreetingProvider(GreetingProvider greetingProvider) {
		this.greetingProvider = greetingProvider;
	}

	public String greetUser(String userName) {
		// TODO Auto-generated method stub
		return greetingProvider.getGreeting()+" "+ userName;
	}

}
