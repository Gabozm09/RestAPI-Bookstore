package com.api.wishlist.repository;

import com.api.wishlist.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findById(String id);
    Book findByName(String name);
}