package com.verizon.cj.ui;

import java.util.Scanner;

public class StringApp {

	public static void main(String[] args) {
		int countWords=0, charCount;
		System.out.println("Enter the string: ");
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		//System.out.println(text);
		charCount = text.length();
		String[] words = text.split(" ");
		countWords = words.length;
		int spaceCount = countWords-1;
		System.out.println("Length: "+charCount+"\nWords: "+countWords+"\nSpaces: "+ spaceCount);
		
		
	}

}
