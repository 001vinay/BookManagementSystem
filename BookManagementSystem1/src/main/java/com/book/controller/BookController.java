package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.entity.Book;
import com.book.entity.MyBookList;
import com.book.service.BookService;
import com.book.service.MyBookListService;

import java.util.*;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	@GetMapping
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
		
	}
	@GetMapping("/books_available")
	public ModelAndView getAllBook() {
List<Book>list=service.getAllBook();
//ModelAndView m=new ModelAndView();
//m.setViewName("bookList");
//m.addObject("book",list);
return new ModelAndView("bookList","book",list);
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/books_available";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		
		return "MyBooks";
	}
@RequestMapping("/myList/{id}")
public String getMyList(@PathVariable("id")int id) {
	Book b=service.getBookById(id);
	MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
	myBookService.saveMyBooks(mb);
	return"redirect:/my_books";
}
@RequestMapping("/editBook/{id}")
public String editBook(@PathVariable("id") int id, Model model) {
	Book b=service.getBookById(id);
	model.addAttribute("book",b);
	return "bookEdit";
}
	 @RequestMapping("/deleteBook/{id}")
	 public String deleteBook(@PathVariable("id") int id, Model model) {
		 service.deleteById(id);
		 return "redirect:/books_available";
	 }
	 

}
