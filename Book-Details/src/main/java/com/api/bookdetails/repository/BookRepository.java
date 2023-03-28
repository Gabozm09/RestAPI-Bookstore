package com.api.bookdetails.repository;

import com.api.bookdetails.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    Book findByIsbn(String isbn);
    List<Book> findByAuthorId(String authorId);

}
