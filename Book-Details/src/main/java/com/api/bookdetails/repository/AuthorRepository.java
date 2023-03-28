package com.api.bookdetails.repository;

import com.api.bookdetails.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
