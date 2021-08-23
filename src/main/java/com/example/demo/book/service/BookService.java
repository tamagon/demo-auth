package com.example.demo.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.book.model.Book;
import com.example.demo.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public List<Book> findAll() {
		return repository.findAll();
	}
	
	public Book newBook(Book newBook) {
		return repository.save(newBook);
	}
	
	public Book findOne1(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book not found " + id));
	}
	public Book findOne(Long id) {
		return repository.findById(id)
				.orElseGet(() -> {throw new BookNotFoundException(id);
				});
	}
	public Book update(Book ubook, Long id) {
		return repository.findById(id)
			.map(x->{
				x.copy(ubook);
				return repository.save(x);
			}).orElseGet(()->{
				throw new RuntimeException("Notfound Book");
			});
	}

	public void deleteBook(Long id) {
		repository.deleteById(id);
	}
	
	public long countAll() {
		return repository.count();
	}
}
