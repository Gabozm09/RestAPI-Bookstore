package com.api.booksearhsorting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.api.booksearhsorting.repository")
public class BooKSearhSortingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooKSearhSortingApplication.class, args);
    }

}
