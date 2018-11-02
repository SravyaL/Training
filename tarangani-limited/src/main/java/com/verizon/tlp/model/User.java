package com.verizon.tlp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name ="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="pack")
	private String pack;
	
	@NotEmpty(message="name cannot be empty")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message="max usage cannot be empty")
	@Pattern(regexp="\\d{10}",message="mobile number can be ony 10 digits")
	@Column(name="mno")
	private String mobile;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Time slot can not be left blank")
	@Column(name="tslot")
	private LocalDate timeSlot;
	
	@Column(name="address")
	private String address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(LocalDate timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
