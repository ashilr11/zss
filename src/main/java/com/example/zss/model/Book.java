package com.example.zss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int book_id;
	private String title;
	private String description;
	private float price;
	@ManyToOne
	@JoinColumn(name="cat_id", nullable=false, insertable=true, updatable=true)
	private Category category; // One book has one category
	
	public Book() {
		super();
	}
	
	public Book(int book_id, String title, String description, float price, Category category) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	
	public int getBookId() {
		return book_id;
	}
	
	public void setId(int book_id) {
		this.book_id = book_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", description=" + description + ", price=" + price + ", category=" + category
				+ "]";
	}	
}
