package com.api.booksearhsorting.controller;

import com.api.booksearhsorting.model.Book;
import com.api.booksearhsorting.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/genre")
    public List<Book> getBooksByGenre(@RequestParam String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/books/top-sellers")
    public List<Book> getTop10Sellers() {
        return bookService.getTop10Sellers();
    }

    @GetMapping("/books/rating")
    public List<Book> getBooksByRating(@RequestParam double rating) {
        return bookService.getBooksByRating(rating);
    }
}