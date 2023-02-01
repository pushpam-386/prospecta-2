package com.push.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.exceptions.BookException;
import com.push.models.BookName;

public interface BookDao extends JpaRepository<BookName, Integer> {
	
	public List<BookName> findByCategory(String category)throws BookException;

}
