package com.verizon.swd.ui;


import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame01 extends JFrame {
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;

	
	public Frame01(){
		button1 = new JButton("BTN 1");
		button2 = new JButton("BTN 2");
		button3 = new JButton("BTN 3");
		button4 = new JButton("BTN 4");
		button5 = new JButton("BTN 5");
		
		add(button1,"North");
		add(button2,"West");
		add(button3,"East");
		add(button4,"South");
		add(button5,"Center");


		setTitle("My first swing screen");
		setBounds(50,50,500,500); //top,left,width,height
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
