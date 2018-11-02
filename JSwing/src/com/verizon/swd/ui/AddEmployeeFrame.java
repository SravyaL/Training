package com.verizon.swd.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class AddEmployeeFrame extends JFrame{
	JPanel pButtons;
	
	JButton bOk;
	JButton bCancel;
	JLabel EmpId,EName,Gender,MaternalStatus,Platform,Skills;
	JTextField tfEmpId, tfEname;
	JRadioButton rbMale, rbFemale;
	ButtonGroup bgrGender, bgrMaternalStatus;
	JToggleButton tgbMarried, tgbUnMarried, tgbMarriedButSingle;
	
	
	public AddEmployeeFrame(){
		pButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bOk = new JButton("OK");
		bCancel = new JButton("Cancel");
		
		pButtons.add(bOk);
		pButtons.add(bCancel);
		add(pButtons,"South");
		
		JPanel pBody = new JPanel(null);
		
		EmpId = new JLabel("Emp ID: ");
		EName = new JLabel("Employee name: ");
		Gender = new JLabel("Gender: ");
		MaternalStatus = new JLabel("Maternal Status: ");
		Platform = new JLabel("Platform: ");
		Skills = new JLabel("Skills ");
		//BoxLayout blayout= new BoxLayout(pBody, BoxLayout.Y_AXIS);
		pBody.setLayout(null);
		
		tfEmpId = new JTextField();
		tfEname = new JTextField();
		
		rbMale = new JRadioButton("Male");
		rbFemale = new JRadioButton("Female");
		tgbMarried = new JToggleButton("Married");
		tgbUnMarried = new JToggleButton("Unmarried");
		tgbMarriedButSingle = new JToggleButton("Married but single");
		bgrMaternalStatus = new ButtonGroup();
		bgrMaternalStatus.add(tgbMarried);
		bgrMaternalStatus.add(tgbUnMarried);
		bgrMaternalStatus.add(tgbMarriedButSingle);

		
		bgrGender = new ButtonGroup();
		bgrGender.add(rbMale);
		bgrGender.add(rbFemale);

		add(pBody,EmpId,20,20,125,25);
		add(pBody,tfEmpId,155,20,125,25);
		add(pBody,EName,20,50,125,25);
		add(pBody,tfEname,155,20,125,25);
		add(pBody,Gender,20,80,125,25);
		add(pBody,rbMale,155,80,75,25);
		add(pBody,rbFemale,235,80,75,25);

		add(pBody,MaternalStatus,20,110,125,25);
		add(pBody,tgbMarried,155,80,75,25);
		add(pBody,tgbUnMarried,240,80,75,25);
		add(pBody,tgbMarriedButSingle,325,80,75,25);

		add(pBody,Platform,20,145,125,25);
		add(pBody,Skills,20,175,125,25);

		
		add(pBody,"Center");
		//pBody.add(new JButton("btn"));
		//pBody.add(new JButton("btn"));
		//pBody.add(new JButton("btn"));
		
		setTitle("Add Employee");
		setBounds(30,30,500,500);
	}
	public void add(Container ct, JComponent cmp,int x,int y, int w, int h){
		cmp.setBounds(x,y,w,h);
		ct.add(cmp);
	}
}
