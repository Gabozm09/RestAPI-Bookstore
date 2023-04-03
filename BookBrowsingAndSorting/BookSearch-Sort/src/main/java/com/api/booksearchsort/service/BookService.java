package com.api.booksearchsort.service;

import com.api.booksearchsort.model.Book;
import com.api.booksearchsort.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getTop10Sellers() {
        return bookRepository.findTop10ByOrderBySoldCopiesDesc();
    }

    public List<Book> getBooksByRating(double rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }

    public void discountBooksByPublisher(double discountPercent, String publisher) {
        List<Book> books = bookRepository.findByPublisher(publisher);

        for (Book book : books) {
            double newPrice = book.getPrice() * (1 - discountPercent / 100);
            book.setPrice(newPrice);
            bookRepository.save(book);
        }
    }
}