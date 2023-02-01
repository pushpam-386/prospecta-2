package com.push.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.push.exceptions.BookException;
import com.push.models.BookName;
import com.push.repository.BookDao;
import com.push.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookDao bookDao;
	

	@PostMapping("/booking/{customerId}")
	public ResponseEntity<BookName> saveBook(@RequestBody BookName book) throws BookException{
		BookName bookName=bookService.saveBookDetails(book);
		return new ResponseEntity<BookName>(bookName,HttpStatus.CREATED);
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<BookName>> getDetalsByCategory(@RequestBody BookName category) throws BookException{
		List<BookName> boook=bookDao.findByCategory(category.getCategory());
		return new ResponseEntity<List<BookName>>(boook,HttpStatus.OK);
	}
	
	

}
