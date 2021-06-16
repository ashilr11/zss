package com.example.zss.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.zss.model.Book;
import com.example.zss.model.Category;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, String>{

	List<Book> findByTitle(String title);
	List<Book> findByDescription(String description);
	List<Book> findByPrice(float price);
	List<Book> findByCategory(Category category);
	
	/*@Modifying
    @Query(value="insert into books (book_id,title,description,price,cat_id) values (:book_id,:title,:description,:price,:cat_id)", nativeQuery=true)
	
    void insertBook(@Param("book_id")int id, @Param("title")String title, @Param("description")String description, @Param("price")float price, @Param("cat_id")int cat_id);
    */
}
