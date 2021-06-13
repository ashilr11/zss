package com.example.zss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zss.model.Book;
import com.example.zss.model.Category;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, String>{

	List<Book> findByTitle(String title);
	List<Book> findByDescription(String description);
	List<Book> findByPrice(float price);
	List<Book> findByCategory(Category category);
}
