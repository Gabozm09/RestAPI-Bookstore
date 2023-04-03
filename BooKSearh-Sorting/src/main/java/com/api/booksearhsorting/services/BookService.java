package com.api.booksearhsorting.services;


import com.api.booksearhsorting.model.Book;
import com.api.booksearhsorting.repository.BookRepository;
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
}

