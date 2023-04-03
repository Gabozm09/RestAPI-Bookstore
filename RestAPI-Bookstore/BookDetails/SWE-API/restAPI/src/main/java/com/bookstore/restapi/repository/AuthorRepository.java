package com.bookstore.restapi.repository;

import com.bookstore.restapi.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
