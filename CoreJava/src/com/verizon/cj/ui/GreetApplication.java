package com.verizon.cj.ui;

import java.util.Scanner;

public class GreetApplication {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.next();
		System.out.println("Hello, "+ name);
	}

}
