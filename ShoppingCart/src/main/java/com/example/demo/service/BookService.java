package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    public Book create(Book book ){
       book.setId(UUID.randomUUID().toString().substring(0, 4));
       return repository.save(book);
    }
    public List<Book> findAllBooks(){
        return repository.findAll();
    }
    public Book findById(String id){
        return repository.findById(id).get();
    }

    public List<Book> getBookBy(Genre genre){
        return repository.findByGenre(genre);
    }

    public void delete(String id){
        Book book = repository.findById(id).get();
        repository.delete(book);
    }

}
