package com.stsapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

@Autowired
private BookService bookService;
	
	@RequestMapping("/books")
	public List<Book>getAllTopics()
	{
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/books/{id}")
	public Book getTopic(@PathVariable String id) {
		return bookService.getBooks(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/books")
	public void addTopic(@RequestBody Book topic) {
bookService.addBook(topic);
}
	
	@RequestMapping(method=RequestMethod.PUT, value="/books/{id}")
			public void updateTopic(@RequestBody Book topic,@PathVariable String id) {
		bookService.updateBook(id,topic);
	}
		@RequestMapping(method=RequestMethod.DELETE, value="/books/{id}")
		public void deleteTopic(@PathVariable String id) {
			 bookService.deleteBook(id);
		}
}

