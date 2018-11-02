package com.springcoredemo.iodemo.ui;

import java.time.LocalDateTime;

public class WelcomeStatementProviderTimlyImpl implements IWelcomeStatementProvider {
	
	public String getWelcomeStatement(){
		String statement = null;
		
		int hour = LocalDateTime.now().getHour();
		
		if(hour>=3 && hour<=11)
			statement = "Good Morning";
		else if(hour>11 && hour<=18)
			statement="Good Noon";
		else 
			statement="Good Evening";
		return statement;
	}

}
