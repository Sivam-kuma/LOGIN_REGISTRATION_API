package com.example.newSearch.Controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newSearch.Entity.book;
import com.example.newSearch.Services.services;

@RestController
@RequestMapping("/api/books")
public class controller {
  
	 @Autowired
	 services newServices;
	 
	 @GetMapping
	    public ResponseEntity<List<book>> getAllBooks() {
	        List<book> books = newServices.getAllBooks();
	        return ResponseEntity.ok(books);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<book> getBookById(@PathVariable Long id) {
	        java.util.Optional<book> book = newServices.getBookById(id);
	        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<book> addBook(@RequestBody book book) {
	        book savedBook = newServices.saveBook(book);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<book> updateBook(@PathVariable Long id, @RequestBody book book) {
	        if (!newServices.getBookById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        book.setId(id);
	        book updatedBook = newServices.saveBook(book);
	        return ResponseEntity.ok(updatedBook);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
	        if (!newServices.getBookById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        newServices.deleteBook(id);
	        return ResponseEntity.noContent().build();
	    }
}
