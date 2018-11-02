package com.verizon.amqpdemo.publisher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;

public class MyMessagePublisher {
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		AmqpTemplate template = ctx.getBean(RabbitTemplate.class);
		
//		for(int i=1;i<=5;i++){
//			String message = "Hello Everybody! "+i;
//			System.out.print("Sending message#"+i+"...");template.convertAndSend(message);
//			System.out.println("sent!");
//			try{
//				Thread.sleep(1500);
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
//		}
		
		while(true){
			LocalDateTime date = LocalDateTime.now();
			String message = "Current time is: " + date;
			template.convertAndSend(message);
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Convert into specific format:");
			System.out.println("1.yyyy-MM-dd HH:mm 2.yyyy-MM-dd HH:mm:ss 3.dd-MM-yyyy HH");
			Scanner s = new Scanner(System.in);
			int x = s.nextInt();
			switch(x){
			case 1:
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				 String message1 = "Current time is: " +  date.format(formatter1);
				 template.convertAndSend(message1);
				 break;
			case 2:
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				 String message2 = "Current time is: " +  date.format(formatter2);
				 template.convertAndSend(message2);
				 break;
			case 3:
				DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");
				 String message3 = "Current time is: " +  date.format(formatter3);
				 template.convertAndSend(message3);
				 break;
			}
			 
			
		}
		
	}

}
