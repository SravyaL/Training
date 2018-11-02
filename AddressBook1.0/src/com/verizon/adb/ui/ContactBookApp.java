package com.verizon.adb.ui;

import java.util.List;
import java.util.Scanner;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;
import com.verizon.adb.service.ContactServiceImpl;
import com.verizon.adb.service.IContactService;

public class ContactBookApp {
	/*static Scanner scan;
	static IContactService contactService;*/
	
	public static void main(String[] args) {
		/*scan = new Scanner(System.in);
		contactService = new ContactServiceImpl();
		Menu choice = null;
		while(Menu.QUIT!=choice){
			System.out.println("Choice \t Operation");
			System.out.println("....................");
			for(Menu m: Menu.values()){
				System.out.println(m.ordinal()+"\t"+m);
			}
			System.out.println("Choice: ");
			int ch = scan.nextInt();
			
			choice = Menu.values()[ch];
			switch(choice){
			case ADD:
				doAdd();
				break;
			case DELETE: 
				doDelete();
				break;
			case UPDATE: 
				doUpdate(); 
				break;
			case SEARCH: 
				doSearch(); 
				break;
			case LIST: 
				doList(); 
				break;
			case QUIT: 
				System.out.println("Prog terminated!");
				break;
			}
		}
		scan.close();*/
		AddressBookHomeScreen screen = new AddressBookHomeScreen();
		screen.setVisible(true);
	}
	
	/*public static void doAdd(){
		Contact c = new Contact();
		System.out.println("Mobile number: ");
		c.setMobileNumber(scan.next());
		System.out.println("Name: ");
		c.setName(scan.next());
		System.out.println("Email-Id: ");
		c.setEmail(scan.next());
		try{
			contactService.add(c);
			System.out.println("Record added!");
		}catch(AddressBookException e){
			System.out.println("Err: "+ e.getMessage());
			
		}
	}
	public static void doUpdate(){
		Contact c = new Contact();
		System.out.println("Old Mobile number: ");
		c.setMobileNumber(scan.next());
		System.out.println("New Name: ");
		c.setName(scan.next());
		System.out.println("New Email-Id: ");
		c.setEmail(scan.next());
		try{
			contactService.update(c);
			System.out.println("Record updated!");

		}catch(AddressBookException e){
			System.out.println("Err: "+ e.getMessage());
			
		}
	}
	public static void doSearch(){
		System.out.println("Mobile number: ");
		String mno = scan.next();
		try{
			Contact c = contactService.findByMobileNumber(mno);
			if(c!=null)
				System.out.println(c);
			else
				System.out.println("Contact not found!");
		}catch(AddressBookException e ){
			System.out.println("Err: "+ e.getMessage());
		}
	}
	public static void doDelete(){
		System.out.println("Mobile number: ");
		String mno = scan.next();
		try{
			boolean isDeleted = contactService.deleteContact(mno);
			
			if(isDeleted)
				System.out.println("Record deleted");
			else
				System.out.println("Contact not found!");
		}catch(AddressBookException e ){
			System.out.println("Err: "+ e.getMessage());
		}
	}
	public static void doList(){
		try{
			List<Contact> contactList = contactService.getAllContacts();
			for(Contact c: contactList)
				System.out.println(c);
			
		} catch(AddressBookException e){
			System.out.println("Err: "+ e.getMessage());
		}
	}*/


}
