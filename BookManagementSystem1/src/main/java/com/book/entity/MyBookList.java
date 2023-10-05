package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MyBooks")
public class MyBookList {
	
	@Id
	private int id;
	private String name;
	private String author;
	private String price;
	
	// Generate Constructor Using Fields--
	
	public MyBookList(int id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		
	}
	// Generate Constructor From Superclass--

	public MyBookList() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Generate Getters And Setter Methods--
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}

