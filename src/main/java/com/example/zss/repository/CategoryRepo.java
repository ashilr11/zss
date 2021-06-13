package com.example.zss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zss.model.Book;
import com.example.zss.model.Category;

public interface CategoryRepo extends JpaRepository<Category, String>{
	
	Category findByTitle(String title);
}
