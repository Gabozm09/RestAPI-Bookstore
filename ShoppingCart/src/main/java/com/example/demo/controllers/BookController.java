package com.example.demo.controllers;

import com.example.demo.service.BookService;
import com.example.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books/")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createCart(@RequestBody Book book){
        return service.create(book);
    }

    @DeleteMapping("{id}")
    public void removeFromCart(@PathVariable String id){

        service.delete(id);
    }
    @PutMapping
    public Book updateBook(Book book){
       return service.create(book);
    }
    @GetMapping("{id}")
    public Book updateBook(@PathVariable String id){
       return service.findById(id);
    }
    @GetMapping
    public List<Book> findAll(){
       return service.findAllBooks();
    }





}
