package com.example.zss.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Card implements Serializable {
	
	private String id;
	private String expiry;
	
	public Card(String id, String expiry) {
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

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", expiry=" + expiry + "]";
	}
	
	
}
