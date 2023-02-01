package com.push.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.exceptions.BookException;
import com.push.models.BookName;
import com.push.repository.BookDao;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public BookName saveBookDetails(BookName bookName) throws BookException {
		
		Optional<BookName> bokk = bookDao.findById(bookName.getBookId());
		if(bokk.isPresent()) {
			throw new BookException("This book is already present with id");
		}else {
			bookDao.save(bokk.get());
		}
		return bokk.get();
	}

}
