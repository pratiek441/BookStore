package com.javabookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javabookstore.entity.Book;
import com.javabookstore.entity.MyBookList;
import com.javabookstore.service.BookService;
import com.javabookstore.service.MyBookListService;

@Controller

public class BookController {
	
	@Autowired
	private MyBookListService myBookService;
	
	private BookService bookService;
	
	

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "book_Register";
	}
	
	/*
	 * @GetMapping("/available_book") public String getAllBook() { return
	 * "bookList"; }
	 */
	
	@GetMapping("/available_book")
	public ModelAndView getAllBook(Model model) {
	
		List<Book> list=bookService.getAllBooks();
		
		return new ModelAndView("bookList","book",list);
		
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b ) {
		bookService.save(b);
		return "redirect:/available_book";
		
	}
	
	@GetMapping("/my_book")
	public String getMyBooks(Model model) {
		
		List<MyBookList> list= myBookService.getAllMyBook();
		model.addAttribute("book",list);
		return "myBook";
	}
	
	@RequestMapping(value="/myList/{id}",method=RequestMethod.GET)
	public String getMyList(@PathVariable("id") int id) {
		Book b= bookService.getBookById(id);
		MyBookList mb= new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_book";	}

	
	  @RequestMapping("/editBook/{id}") 
	  public String editBook(@PathVariable("id") int id , Model model) {
		  Book book=bookService.getBookById(id);
		  model.addAttribute("book", book);
		  return "bookEdit"; }
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		
		bookService.deleteById(id);
		
		return "redirect:/available_book";
		
	}
	  
	
	
}
