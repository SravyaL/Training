package com.verizon.iocdemo.ui;

import java.util.Scanner;

import com.verizon.iocdemo.service.IUserService;
import com.verizon.iocdemo.service.UserServiceDefaultImpl;

public class App01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String userName = scan.next();
		IUserService userService = new UserServiceDefaultImpl();
		System.out.println(userService.welcomeUser(userName));
		scan.close();
	}

}
