package com.example.demo.book.service;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(Long id) {
		super("Bood id not found : " + id);
	}
}
