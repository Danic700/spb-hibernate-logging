package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	 @Autowired
	 private BookRepository bookRepository;
	
	@Override
	public List<Book> retrieveBooks() {
		
		return bookRepository.findAll();
	}

}
