package com.verizon.ram.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	private long uid;
	
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private String name;
	
	private long mid;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public Users() {
		super();
	}

	public Users(long uid, String emailid, String pwd, Role role, String name, long mgrid) {
		super();
		this.uid = uid;
		this.email = emailid;
		this.password = pwd;
		this.role = role;
		this.name = name;
		this.mid = mgrid;
	}
	
	
}
