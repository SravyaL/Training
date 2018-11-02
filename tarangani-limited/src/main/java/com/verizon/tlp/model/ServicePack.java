package com.verizon.tlp.model;

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
@Table(name = "services")
public class ServicePack {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String title;
	
	@NotEmpty(message="net speed cannot be empty")
	@Column(name="speed")
	private long speed;
	
	@NotEmpty(message="max usage cannot be empty")
	@Column(name="max")
	private long maxUsage;
	
	
	@NotEmpty(message="charge per month can not be null")
	@Column(name="cpm")
	private long chargePM;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public long getSpeed() {
		return speed;
	}


	public void setSpeed(long speed) {
		this.speed = speed;
	}


	public long getMaxUsage() {
		return maxUsage;
	}


	public void setMaxUsage(long maxUsage) {
		this.maxUsage = maxUsage;
	}


	public long getChargePM() {
		return chargePM;
	}


	public void setChargePM(long chargePM) {
		this.chargePM = chargePM;
	}
	

}
