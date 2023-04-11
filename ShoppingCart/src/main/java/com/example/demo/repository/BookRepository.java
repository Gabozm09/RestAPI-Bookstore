package com.example.demo.repository;

import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
     List<Book> findByGenre(Genre genre);

}
