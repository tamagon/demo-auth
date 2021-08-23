package com.example.demo.book.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String author;
	private BigDecimal price;
	
	
	private String isbn;
	
	
	public void copy(Book b) {
		this.setAuthor(b.getAuthor());
		this.setIsbn(b.getIsbn());
		this.setName(b.getName());
		this.setPrice(b.getPrice());
	}

}
