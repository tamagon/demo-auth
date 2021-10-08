package com.example.demo;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.book.model.Book;
import com.example.demo.book.repository.BookRepository;
import com.example.demo.book.service.BookService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatabase(BookService service) {
		return args -> {
			if (service.countAll() == 0) {
				service.newBook(Book.builder().name("A Guide to Way of Life").author("Santideva").price(new BigDecimal("15.41")).isbn("AB-1234").build());
				service.newBook(Book.builder().name("The Life Changing Magic").author("Marid Kondo").price(new BigDecimal("9.69")).isbn("AB-1235").build());
				service.newBook(Book.builder().name("Refactoring: Improving the Design of Existing Code").author("Martin Fowler").price(new BigDecimal("47.99")).isbn("AB-1236").build());
			}
		};
		
		
	}

}
