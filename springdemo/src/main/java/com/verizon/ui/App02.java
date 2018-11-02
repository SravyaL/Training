package com.verizon.ui;


import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.verizon.service.*;

public class App02  {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanDefinition01.xml");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name:");
		String userName = scan.next();
		
		GreetingProvider ws2 = (GreetingProvider) ctx.getBean("wel001");
		
		System.out.println(ws2.getGreeting());
		
GreetingProvider ws3 = (GreetingProvider) ctx.getBean("wel001");
		
		System.out.println(ws3.getGreeting());


	}

}
