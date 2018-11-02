package com.verizon.adb.service;

import java.util.List;

import com.verizon.adb.dao.ContactDaoFileBasedImpl;
import com.verizon.adb.dao.ContactDaoJDBC;
import com.verizon.adb.dao.IContactDao;
import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;

public class ContactServiceImpl implements IContactService {

	private IContactDao contactDao = null;
	public ContactServiceImpl(){
		//contactDao = new ContactDaoFileBasedImpl();
		contactDao = new ContactDaoJDBC();
	}
	
	private boolean isValidName(String name){
		String nameRegEx = "[A-Z][A-Za-z]{3,14}";
		return name!=null && name.matches(nameRegEx);
	}
	
	private boolean isValidEmail(String email){
		return email!=null && email.contains("@");
		
	}
	private boolean isValidMobileNumber(String mobileNumber){
		String mnoRegEx="\\d{10}";
		return mobileNumber!=null && mobileNumber.matches(mnoRegEx);
	}
	@Override
	public boolean isValid(Contact contact) throws AddressBookException{
		boolean isValid = true;
		StringBuilder errs = new StringBuilder();
		if(!isValidMobileNumber(contact.getMobileNumber())){
			errs.append("must be 10 digits");
			isValid=false;
		}
		if(!isValidName(contact.getName())){
			errs.append("name must be init caped");
			isValid=false;
		}
		if(!isValidEmail(contact.getEmail())){
			errs.append("Invalid email");
			isValid=false;
		}
		if(!isValid){
			throw new AddressBookException(errs.toString());
		}
		return isValid;
	}
	@Override
	public Contact add(Contact contact) throws AddressBookException {
		if(contact!=null && isValid(contact)){
			contactDao.add(contact);
		}
		return contact;
	}

	@Override
	public Contact findByMobileNumber(String mobileNumber) throws AddressBookException {
		// TODO Auto-generated method stub
		return contactDao.findByMobileNumber(mobileNumber);
	}

	@Override
	public Contact update(Contact contact) throws AddressBookException {
		if(contact!=null && isValid(contact)){
			contactDao.update(contact);
		}
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() throws AddressBookException {
		// TODO Auto-generated method stub
		return contactDao.getAllContacts();
	}

	@Override
	public boolean deleteContact(String mobileNumber) throws AddressBookException {
		// TODO Auto-generated method stub
		return contactDao.deleteContact(mobileNumber);
	}

}
