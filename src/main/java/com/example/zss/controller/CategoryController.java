package com.example.zss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.zss.model.Book;
import com.example.zss.model.Category;
import com.example.zss.repository.BookRepo;
import com.example.zss.repository.CategoryRepo;

@RestController
public class CategoryController{
	
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	// Get all categories
	@GetMapping(path="/categories")
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	// Post a category 
	@PostMapping(path="/categories", consumes= {"application/json"})
	public Category addCategory(@RequestBody Category category) {
		categoryRepo.save(category);
		return category;
	}
	
	// Get all books in a specific category using the ategory title
	@RequestMapping("/category")
	public List<Book> getCategory(@RequestParam("title") String title){
		return bookRepo.findByCategory(categoryRepo.findByTitle(title));

	}
}
