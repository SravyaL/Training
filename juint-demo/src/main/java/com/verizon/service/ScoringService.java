package com.verizon.service;

import com.verizon.model.Grade;

public class ScoringService {
	public Grade getGrade(double avg){
		Grade g = null;
		
		if(avg>=90) g = Grade.A;
		else if(avg>=80) g = Grade.B;
		else if(avg>=70) g = Grade.C;
		else g =Grade.F;
		
		return g;
		
	}
}
