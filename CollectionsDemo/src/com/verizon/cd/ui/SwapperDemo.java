package com.verizon.cd.ui;

import java.time.LocalDate;

import com.verizon.cd.model.Book;
import com.verizon.cd.service.Swapper;

public class SwapperDemo {

	public static void main(String[] args) {
		char c1='$', c2 = '#';
		Swapper<Character> cSwap= new Swapper<>();
		cSwap.doSwap(c1, c2);
		
		int a1=22, a2=19;
		Swapper<Integer> cSwap1= new Swapper<>();
		cSwap1.doSwap(a1, a2);
		
		String s1="Mayo", s2="Srav";
		Swapper<String> cSwap3= new Swapper<>();
		cSwap3.doSwap(s1, s2);
		
		
		Book b1 = new Book(101, "TFIOS",LocalDate.now(),250);
		Book b2 = new Book(102,"Turtles All The Way Down", LocalDate.now(),350);
		
		Swapper<Book> bSwap = new Swapper<>();
		bSwap.doSwap(b1, b2);
		System.out.println(b1.compareTo(b2));
	}

}
