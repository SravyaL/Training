package com.verizon.sad.model;

import java.util.Comparator;

public class SortByTitle implements Comparator<Subject> {
	@Override
	public int compare(Subject o1, Subject o2) {
		return (o1.subtitle.compareTo(o2.subtitle));
	}
}
