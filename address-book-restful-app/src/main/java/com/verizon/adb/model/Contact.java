package com.verizon.adb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="contacts")
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long contactId;
	@NotEmpty(message="firstname can not be empty")
	@Size(min=5,max=15,message="firstname  must be of 5 to 15 chars")
	private String fnm;
	@NotEmpty(message="lastname can not be empty")
	@Size(min=5,max=15,message="lastname  must be of 5 to 15 chars")
	private String lnm;
	
	@NotNull(message="Date of birth cannot be left blank")
	@Column(name="dob")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate dateOfBirth;
	
	@NotNull(message="Email cannot be null")
	@Email
	private String emailId;
	
	@NotNull(message="Mobile number can't be empty")
	@Pattern(regexp="\\d{10}", message="mobile number should be only 10 digits")
	@Column(name="mno")
	private String mobileNumber;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getFnm() {
		return fnm;
	}
	public void setFnm(String fnm) {
		this.fnm = fnm;
	}
	public String getLnm() {
		return lnm;
	}
	public void setLnm(String lnm) {
		this.lnm = lnm;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	

}
