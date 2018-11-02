package com.verizon.adb.dao;

import java.util.List;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;

public interface IContactDao {
	
	Contact add(Contact contact) throws AddressBookException;
	Contact findByMobileNumber(String mobileNumber) throws AddressBookException;
	Contact update(Contact contact) throws AddressBookException;
	List<Contact> getAllContacts() throws AddressBookException;
	boolean deleteContact(String mobileNumber) throws AddressBookException;

}
