package com.example.zss.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	private int cat_id;
	private String title;
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private List<Book> books;
	
	public Category() {
		super();
	}
	
	public Category(int catId, String title) {
		super();
		this.cat_id = catId;
		this.title = title;
	}

	public int getCatId() {
		return cat_id;
	}

	public void setCatId(int catId) {
		this.cat_id = catId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Category [catId=" + cat_id + ", title=" + title + "]";
	}
		
}
