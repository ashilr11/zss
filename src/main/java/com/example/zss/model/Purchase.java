package com.example.zss.model;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Purchase implements Serializable {
	
	
	private String type = "PURCHASE";
	private String extendedType = "NONE";
	private float amount;
	private String created;
	private String reference;
	private String narration;
	private Map<String, Object> additionalData;
	private Card card;
	
	public Purchase() {
		this.type = "PURCHASE";
		this.extendedType = "NONE";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		created = df.format(new Date());;
		
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    reference = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    additionalData = null;
	    narration = "this is a narration";

	}
	
	public Purchase(String type, String extendedType, float amount, String created, String reference, String narration,
			Map<String, Object> additionalData, Card card) {
		super();
		this.type = "PURCHASE";
		this.extendedType = "NONE";
		this.amount = amount;
		this.created = created;
		this.reference = reference;
		this.narration = narration;
		this.additionalData = additionalData;
		this.card = card;
	}

	public String getType() {
		return type;
	}

	public String getExtendedType() {
		return extendedType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNarration() {
		return narration;
	}

	
	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Map<String, Object> getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(Map<String, Object> additionalData) {
		this.additionalData = additionalData;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}
