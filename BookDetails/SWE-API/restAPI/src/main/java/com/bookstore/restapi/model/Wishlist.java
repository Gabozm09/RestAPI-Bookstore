package com.bookstore.restapi.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.List;

public class Wishlist {
    @Id
    private String id;
    private String name;
    private String userId;
    private List<Book> bookList;

    public Wishlist(String name, String userId, List<Book> bookList){
        this.name = name;
        this.userId = userId;
        this.bookList = bookList;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public List<Book> getBookList(){
        return bookList;
    }

    public void setBookList(List<Book> bookList){
        this.bookList = bookList;
    }



}
