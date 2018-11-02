package com.verizon.subswing.model;

import java.io.Serializable;

public class Subject implements Serializable {
	private int subjectId;
	private String subtitle;
	private int durationInHours;
	
	public Subject() {
		
	}

	public Subject(int subjectId, String subtitle, int durationInHours) {
		super();
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationlnHours=" + durationInHours
				+ "]";
	} 

}
