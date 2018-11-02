package com.verizon.sad.model;

import java.util.Comparator;

public class SortByDuration implements Comparator<Subject> {
	@Override
	public int compare(Subject o1, Subject o2) {
		return (int) (o1.durationInHours - o2.durationInHours);
	}
}
