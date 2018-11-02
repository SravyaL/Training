package com.verizon.cd.ui;

public class ComparableDemo {

	public static void main(String[] args) {
		Integer iobj1 = 45;
		Integer iobj2 = 67;
		
		System.out.println(iobj1.compareTo(iobj2));
		System.out.println(iobj1.compareTo(iobj1));
		System.out.println(iobj2.compareTo(iobj1));
		
	}

}
