package com.stsapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		 List<Book>books =new ArrayList<>();
		bookRepository.findAll()
		.forEach(books ::add);
		return books;
	}
	
	public Book getBooks(String id) {
		return bookRepository.findById(id).get();
		
	}

	public void addBook(Book book) {
		bookRepository.save(book);
		
		
	}

	public void updateBook(String id, Book Book) {
		bookRepository.save(Book);
	}
	public void deleteBook(String id) {
		bookRepository.deleteById(id);
	}
}
