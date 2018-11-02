package com.verizon.cd.model;

import java.time.LocalDate;

public class Book implements Comparable<Book>{
	private int bcode;
	private String title;
	private LocalDate dateOfPublish;
	private double price;
	
	public Book(){
		
	}
	
	public Book(int bcode, String title, LocalDate dateOfPublish, double price) {
		super();
		this.bcode = bcode;
		this.title = title;
		this.dateOfPublish = dateOfPublish;
		this.price = price;
	}

	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDateOfPublish() {
		return dateOfPublish;
	}
	public void setDateOfPublish(LocalDate dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bcode=" + bcode + ", title=" + title + ", dateOfPublish=" + dateOfPublish + ", price=" + price
				+ "]";
	}

	@Override
	public int compareTo(Book b1) {
		Integer bcode1 = this.bcode;
		Integer bcode2 = b1.bcode;
		return bcode1.compareTo(bcode2);
	}
	

}
