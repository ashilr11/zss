package com.example.zss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.zss.model.Card;
import com.example.zss.model.Purchase;
import com.example.zss.repository.BookRepo;

@RestController
public class PurchaseController {
	
	private final String bearerToken = "9ca3d5ed-dc04-4700-8dd6-7d60c3cdf0fa";
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@Autowired
	private BookRepo bookRepo;
	
	// Make a purchase (HTTP request parameters needed are book title, cardID and cardExpiry)
	@PostMapping(path="/purchase")
	public String makePurchase(@RequestParam("title") String title, @RequestParam("cardID") String cardID, @RequestParam("cardExpiry") String cardExpiry) {
		
		final String url = "https://lab.v.co.zw/interview/api/transaction";
		restTemplate = new RestTemplate();
		
		// Add HTTP headers
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(bearerToken);
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create purchase object to be posted
		Card card = new Card(cardID, cardExpiry);
		Purchase purchase = new Purchase();
		purchase.setAmount(bookRepo.findByTitle(title).get(0).getPrice());
		purchase.setCard(card);
		HttpEntity<Purchase> requestEntity = new HttpEntity<Purchase>(purchase, headers);

		// Sent POST request and get response
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
	}	
}
