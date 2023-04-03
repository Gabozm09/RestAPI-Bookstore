package com.bookstore.restapi.controller;

import com.bookstore.restapi.repository.BookRepository;
import com.bookstore.restapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Create a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    // Get a book by its ISBN
    @GetMapping("/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

}
