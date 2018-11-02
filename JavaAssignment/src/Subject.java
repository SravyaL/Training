
public class Subject implements Comparable<Subject>{
	long subjectId;
	String subtitle;
	int durationInHours;
	
	public Subject(){
		
	}
	
	public Subject(long subjectId, String subtitle, int durationInHours) {
		
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
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
		if(this.subjectId == o.subjectId)
			return 1;
		else
			return 0;
	}

		
}
