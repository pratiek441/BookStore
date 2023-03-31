package com.javabookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javabookstore.entity.MyBookList;
import com.javabookstore.repository.MyBookListRepository;

@Service
public class MyBookListService {

	private MyBookListRepository myBookListRepo;
	
	
	public MyBookListService(MyBookListRepository myBookListRepo) {
		super();
		this.myBookListRepo = myBookListRepo;
	}


	public void saveMyBooks(MyBookList book) {
		
		myBookListRepo.save(book);
		
	}
	
	public List<MyBookList> getAllMyBook(){
		return myBookListRepo.findAll();
	}
	
	
	public void deleteById(int id) {
		myBookListRepo.deleteById(id);
	}
}
