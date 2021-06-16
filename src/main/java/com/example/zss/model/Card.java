package com.example.zss.model;

import java.io.Serializable;

public class Card implements Serializable {
	
	private static final long serialVersionUID = 1L;
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
