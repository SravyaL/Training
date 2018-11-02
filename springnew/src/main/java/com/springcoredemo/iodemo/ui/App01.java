package com.springcoredemo.iodemo.ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("deprecation")
public class App01 {

	public static void main(String[] args) {
		
//		Resource beanDfRes = new ClassPathResource("beanDefinition.xml");
//		@SuppressWarnings("deprecation")
//		BeanFactory context = new XmlBeanFactory(beanDfRes);
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beanDefinition.xml");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter User Name");

		String userName = scan.next();
		IUserService userService = (IUserService) context.getBean("udsBean");
		System.out.println(userService.welcomeUser(userName));
		
		IUserService userService2 = (IUserService) context.getBean("upsBean");
		System.out.println(userService2.welcomeUser(userName));
		
		IUserService userService3 = (IUserService) context.getBean("useBean");
		System.out.println(userService3.welcomeUser(userName));
		

		scan.close();
		
	}

}
