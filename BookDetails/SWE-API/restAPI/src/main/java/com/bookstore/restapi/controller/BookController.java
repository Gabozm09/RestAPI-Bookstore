package com.bookstore.restapi.controller;

import com.bookstore.restapi.ErrorHandling.DuplicateIsbnException;
import com.bookstore.restapi.repository.BookRepository;
import com.bookstore.restapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Create a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody Book book) {
        Book existingBook = bookRepository.findByIsbn(book.getIsbn());
        if (existingBook != null) {
            throw new DuplicateIsbnException("A book with the ISBN " + book.getIsbn() + " already exists.");
        }
        bookRepository.save(book);
    }

    // Get a book by its ISBN
    @GetMapping("/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @ExceptionHandler(DuplicateIsbnException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleDuplicateIsbnException(DuplicateIsbnException e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", e.getMessage());
        return errorResponse;
    }


}
