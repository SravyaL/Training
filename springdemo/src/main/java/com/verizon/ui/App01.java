package com.verizon.ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.verizon.service.*;
public class App01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanDefinition01.xml");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name:");
		String userName = scan.next();
		welcomeService ws = (welcomeService) ctx.getBean("wel001");
		//welcomeService ws = new SimpleTest("Hello ");
		System.out.println(ws.greetUser(userName));
		GreetingProvider ws2 = (GreetingProvider) ctx.getBean("wel02");
		//welcomeService ws1 = new SimpleTest("Hello ");
		System.out.println(ws2.getGreeting());


	}

}
