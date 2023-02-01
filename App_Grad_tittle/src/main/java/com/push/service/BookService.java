package com.push.service;

import com.push.exceptions.BookException;
import com.push.models.BookName;

public interface BookService {
	
	public BookName saveBookDetails(BookName bookName) throws BookException;

}
