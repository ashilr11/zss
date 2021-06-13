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
import com.example.zss.model.Category;
import com.example.zss.repository.BookRepo;
import com.example.zss.repository.CategoryRepo;

@RestController
public class CategoryController{
	
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@GetMapping(path="/categories")
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	@PostMapping(path="/categories", consumes= {"application/json"})
	public Category addCategory(@RequestBody Category category) {
		categoryRepo.save(category);
		return category;
	}
	
	@RequestMapping("/category")
	public List<Book> getCategory(@RequestParam("title") String title){
		return bookRepo.findByCategory(categoryRepo.findByTitle(title));

	}
}
