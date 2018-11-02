package com.verizon.swd.ui;


//import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame03 extends JFrame {
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;

	
	public Frame03(){
		button1 = new JButton("BTN 1");
		button2 = new JButton("BTN 2");
		button3 = new JButton("BTN 3");
		button4 = new JButton("BTN 4");
		button5 = new JButton("BTN 5");
		
		setLayout(new GridLayout(3,2));//row,col
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);


		setTitle("My first swing screen");
		setBounds(50,50,500,500); //top,left,width,height
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
