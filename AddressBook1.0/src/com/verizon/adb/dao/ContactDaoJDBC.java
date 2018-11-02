package com.verizon.adb.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;
import com.verizon.jd.ui.ConnectionProvider;

public class ContactDaoJDBC implements IContactDao {

	public ContactDaoJDBC() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Contact add(Contact contact) throws AddressBookException {
		if (contact != null) {

			try (Connection con = ConnectionProvider.getInstance().getConnection();
					PreparedStatement st = con.prepareStatement(IqueryMapper.INS_CONT_QRY);) {
				st.setString(1, contact.getMobileNumber());
				st.setString(2, contact.getName());
				st.setString(3, contact.getEmail());
				st.executeUpdate();
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return contact;
	}

	@Override
	public Contact findByMobileNumber(String mobileNumber) throws AddressBookException {

		Contact contact = null;
		try (Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement st = con.prepareStatement(IqueryMapper.SEL_CONT_BY_CONT_QRY);) {
			st.setString(1, mobileNumber);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				contact = new Contact();
				contact.setMobileNumber(rs.getString(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
	}

	@Override
	public Contact update(Contact contact) throws AddressBookException {

		if (contact != null) {
			try (Connection con = ConnectionProvider.getInstance().getConnection();
					PreparedStatement st = con.prepareStatement(IqueryMapper.UPD_CONT_QRY);) {
				st.setString(3, contact.getMobileNumber());
				st.setString(1, contact.getName());
				st.setString(2, contact.getEmail());
				st.executeUpdate();
			} catch (SQLException | ClassNotFoundException e) {
				throw new AddressBookException("Insertion Failed! Err:" + e.getMessage());
			}
		}
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() throws AddressBookException {

		List<Contact> list = new ArrayList<>();
		try (Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement st = con.prepareStatement(IqueryMapper.SEL_ALL_CONT_QRY);) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setMobileNumber(rs.getString(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				list.add(contact);

			}

		} catch (SQLException | ClassNotFoundException e) {
			throw new AddressBookException("Retrieval Failed! Err:" + e.getMessage());
		}
		return list;
	}

	@Override
	public boolean deleteContact(String mobileNumber) throws AddressBookException {

		boolean isDeleted = false;
		try (Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement st = con.prepareStatement(IqueryMapper.DEL_CONT_QRY);) {
			st.setString(1, mobileNumber);
			int count = st.executeUpdate();
			if (count == 0)
				isDeleted = false;
			else
				isDeleted = true;
		} catch (SQLException | ClassNotFoundException e) {
			throw new AddressBookException("Retrieval Failed! Err:" + e.getMessage());
		}
		return isDeleted;

	}
}
