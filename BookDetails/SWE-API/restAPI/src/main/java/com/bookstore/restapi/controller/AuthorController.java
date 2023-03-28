package com.bookstore.restapi.controller;

import com.bookstore.restapi.model.Book;
import com.bookstore.restapi.repository.AuthorRepository;
import com.bookstore.restapi.model.Author;
import com.bookstore.restapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    // Create a new author
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(@RequestBody Author author) {
        authorRepository.save(author);
    }

    // Get a list of books associated with an author
    @GetMapping("/{authorId}/books")
    public List<Book> getBooksByAuthor(@PathVariable String authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

}