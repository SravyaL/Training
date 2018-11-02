package com.verizon.adb.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;
import com.verizon.adb.service.ContactServiceImpl;
import com.verizon.adb.service.IContactService;

public class AddressBookHomeScreen extends JFrame {
	JMenuBar menuBar;
	JTable table;
	DefaultTableModel model;
	IContactService contactService = new ContactServiceImpl();
	
	public AddressBookHomeScreen(){
		
		contactService = new ContactServiceImpl();
		createMenuBar();
		model= new  DefaultTableModel(new String[]{"Mobile#", "Name","E-mail"},0);
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		add(new JScrollPane(table));
		
		loadData();
		
		setTitle("Address Book 2.0");
		int width = 500;
		int height = 500;
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(dim.getWidth()-width)/2,
		(int)(dim.getHeight()-height)/2,width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void loadData() {
		try{
		List<Contact> contactList = contactService.getAllContacts();
		for(Contact c : contactList){
			Object[] row = new Object[3];
			row[0] = c.getMobileNumber();
			row[1] = c.getName();
			row[2] = c.getEmail();
			model.addRow(row);
			
		}
		}
		catch(AddressBookException e){
			JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	private void createMenuBar(){
		HomeScreenActionAdapter adp = new HomeScreenActionAdapter();
		menuBar = new JMenuBar();
		JMenu mnFile = menuBar.add(new JMenu("File"));
		JMenu mnView = menuBar.add(new JMenu("View"));
		
		setJMenuBar(menuBar);
		
		JMenuItem m1 = mnFile.add("New Contact");
		m1.setMnemonic('N');
		m1.addActionListener(adp);
		
		mnFile.addSeparator();
		
		JMenuItem m2 = mnFile.add("Search");
		m2.setMnemonic('S');
		m2.addActionListener(adp);
		
		JMenuItem m3 = mnFile.add("Edit");
		m3.setMnemonic('E');
		m3.addActionListener(adp);
		
		JMenuItem m4 = mnFile.add("Delete");
		m4.setMnemonic('D');
		m4.addActionListener(adp);
		
		mnFile.addSeparator();
		
		JMenuItem m5 = mnFile.add("Exit");
		m5.setMnemonic('X');
		m5.addActionListener(adp);
		
		JMenu mnSort = (JMenu)mnView.add(new JMenu("Sort"));
		JMenuItem m6=mnSort.add("By Name");
		m6.addActionListener(adp);
		JMenuItem m7=mnSort.add("By Mail");
		m7.addActionListener(adp);
		JMenuItem m8=mnSort.add("By Mobile Number");
		m8.addActionListener(adp);
		
		
	}
	
	class HomeScreenActionAdapter implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String cmd = e.getActionCommand();
			switch(cmd){
			case "New Contact":
				doNewContact();
				break;
			case "Exit":
				dispose();
				break;
			default:
				JOptionPane.showMessageDialog(null, cmd+ "Menu Item Clicked!");

			}
		}

		private void doNewContact() {
			ContactEntryScreen entryScreen = new ContactEntryScreen(this,null);
			entryScreen.setVisible(true);
		}
	}
}
