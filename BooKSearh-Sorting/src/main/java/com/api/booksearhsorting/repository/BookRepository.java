package com.api.booksearhsorting.repository;

import com.api.booksearhsorting.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findTop10ByOrderBySoldCopiesDesc();
    List<Book> findByRatingGreaterThanEqual(double rating);

    @Query("{'publisher': ?0}")
    List<Book> findByPublisher(String publisher);
}