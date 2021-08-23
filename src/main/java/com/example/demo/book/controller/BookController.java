package com.example.demo.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.book.model.Book;
import com.example.demo.book.service.BookService;

@RestController
@Validated
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/books")
	List<Book> findAll(){
		return service.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/books")
	Book newBook(@RequestBody Book newBook) {
		return service.newBook(newBook);
	}
	@PutMapping("/books/{id}")
	Book update(@RequestBody Book newBook, @PathVariable Long id) {
		return service.update(newBook, id);
	}
	
	@GetMapping("/books/{id}")
	Book findOne(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		service.deleteBook(id);
	}
}
