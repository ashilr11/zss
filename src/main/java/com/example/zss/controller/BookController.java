package com.example.zss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.zss.model.Book;
import com.example.zss.repository.BookRepo;

@RestController
public class BookController {
	
	@Autowired
	private BookRepo bookRepo;
	
	@GetMapping(path="/books")
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	@PostMapping(path="/books", consumes= {"application/json"})
	public Book addBook(@RequestBody Book book) {
		bookRepo.save(book);
		return book;
	}
	
	@RequestMapping("/book")
	public List<Book> getBook(@RequestParam("title") String title){
		return bookRepo.findByTitle(title);

	}
}
