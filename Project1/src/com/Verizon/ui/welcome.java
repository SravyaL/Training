package com.Verizon.ui;

import java.util.Scanner;

public class welcome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String fName = scan.nextLine();
		String lName = scan.nextLine();
		String name = fName + " " + lName;
		System.out.println(name);
	}

}
