package com.javabookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javabookstore.service.MyBookListService;

@Controller
public class MyBookController {

	private MyBookListService myBookservice;
	
	
	public MyBookController(MyBookListService myBookservice) {
		super();
		this.myBookservice = myBookservice;
	}


	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		
		myBookservice.deleteById(id);
		
		return "redirect:/my_book";
		
	}
}
