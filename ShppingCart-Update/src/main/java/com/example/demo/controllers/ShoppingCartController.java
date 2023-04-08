package com.example.demo.controllers;

import com.example.demo.domain.ShoppingCart.Book;
import com.example.demo.domain.ShoppingCart.ShoppingCart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {
    private ShoppingCart cart;

    public ShoppingCartController(ShoppingCart cart) {
        this.cart = cart;
    }
    @GetMapping("/bookList")
    public  List<Book> getBooksFromCart(){
        return cart.getBookList();
    }
    @GetMapping("/subtotal")
    public  double getSubtotal(){
        return cart.getSubtotal().doubleValue();
    }
    @GetMapping("/total")
    public  double total(){
        return cart.getTotal().doubleValue();
    }
    @PostMapping("/addBook")
    public  void addBookToCart(Book book){
        cart.addBookToCart(book);
    }

    @PostMapping("/removeBook")
    public void removeFromCart(Book book){
        cart.removeBookFromCart(book.getId());
    }
}
