package com.verizon.service;

import java.time.LocalDateTime;

public class HourBasedGreetingProvider implements GreetingProvider {

	public String getGreeting() {
		// TODO Auto-generated method stub
		String greeting = null;
		int currentHour = LocalDateTime.now().getHour();
		if(currentHour>=3 && currentHour<=11)
			greeting = "Good Morning";
		else if (currentHour<=16)
			greeting = "Good noon";
		else
			greeting = "good night";
		return greeting;
	}

}
