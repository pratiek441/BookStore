package com.javabookstore.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabookstore.entity.Book;
import com.javabookstore.repository.BookRepository;

@Service
public class BookService {

	
	private BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	public void save(Book b) {
		
		bookRepo.save(b);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
		
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}
	
	
}
