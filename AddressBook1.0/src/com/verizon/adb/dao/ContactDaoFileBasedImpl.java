package com.verizon.adb.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;

public class ContactDaoFileBasedImpl implements IContactDao {

	public static final String DATA_STORE = "addressBook.data";
	
	private TreeMap<String,Contact> contacts;
	public ContactDaoFileBasedImpl() {
		
		boolean isLoaded = loadData();
		if(isLoaded){
		contacts = new TreeMap<String,Contact>();
		//System.out.println("....0");
		}
}


private boolean loadData() {
	boolean isLoaded = false;
	try(ObjectInputStream fin = new ObjectInputStream(new FileInputStream(DATA_STORE));){
		Object obj = fin.readObject();
if(obj instanceof Map){
	contacts = (TreeMap<String, Contact>)obj;
	isLoaded=true;
}
}catch(IOException | ClassNotFoundException e){
	isLoaded = true;
	
}
	return isLoaded;
	
}
private void saveData() throws FileNotFoundException, IOException, AddressBookException{
	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_STORE));){
		out.writeObject(contacts);
	}catch(IOException e){
		throw new AddressBookException("Data stored is corrupt/ not available");
	}
}
	@Override
	public Contact add(Contact contact) throws AddressBookException {
		System.out.println(contact);

		if(contact!=null){
			//System.out.println(".....");
			//System.out.println(contact.getMobileNumber());
			//System.out.println(contact);
			//if(contact!=null && contact.getMobileNumber()!=null)
				contacts.put(contact.getMobileNumber(), contact);
			System.out.println(contact);
			try {
				saveData();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return contact;
	}
	
	@Override
	public Contact findByMobileNumber(String mobileNumber) throws AddressBookException {
		
		return contacts.get(mobileNumber);
	}

	@Override
	public Contact update(Contact contact) throws AddressBookException {
		contacts.replace(contact.getMobileNumber(), contact);
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() throws AddressBookException {
		
		return new ArrayList<Contact>(contacts.values());
	}

	@Override
	public boolean deleteContact(String mobileNumber) throws AddressBookException {
		boolean isDeleted= false;
		if(contacts.containsKey(mobileNumber)){
			contacts.remove(mobileNumber);
			try {
				saveData();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isDeleted = true;
		}
		return isDeleted;
	}

}
