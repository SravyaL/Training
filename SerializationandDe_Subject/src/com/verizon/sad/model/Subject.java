package com.verizon.sad.model;

public class Subject implements Comparable<Subject> {
	long subjectId;
	String subtitle;
	int durationInHours;

	public Subject() {

	}



	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
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
	public int compareTo(Subject o) {
		int x = 0;
		if (this.subjectId - o.subjectId == 0) {
			if (this.subtitle.equals(o.subtitle)) {
				if (this.durationInHours - o.durationInHours == 0) {
					x = 1;
				}
			}
		} else
			x = -1;
		return x;
	}

	@Override
	public String toString() {
		return "SubjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours;
	}

}





