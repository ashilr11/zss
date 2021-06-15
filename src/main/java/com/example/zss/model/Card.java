package com.example.zss.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Card implements Serializable {
	
	private String id;
	private Date expiry;
	
	public Card(String id, Date expiry) {
		super();
		this.id = id;
		this.expiry = expiry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", expiry=" + expiry + "]";
	}
	
	
}
