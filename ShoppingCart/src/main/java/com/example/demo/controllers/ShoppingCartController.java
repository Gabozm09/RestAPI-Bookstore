package com.example.demo.controllers;

import com.example.demo.service.BookService;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.domain.Book;
import com.example.demo.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("carts/")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private BookService bookService;


    @GetMapping("bookList")
    public List<Book> getBooksFromCart(@RequestBody Map<String, String> request) {
        ShoppingCart cart = shoppingCartService.findByUserId(request.get("userId"));
        return cart.getBookList();
    }

    @GetMapping("subtotal")
    public double getSubtotal(@RequestBody Map<String, String> request) {
        ShoppingCart cart = shoppingCartService.findByUserId(request.get("userId"));
        return cart.getSubtotal().doubleValue();
    }

    @GetMapping("total")
    public double total(@RequestBody Map<String, String> request) {
        ShoppingCart cart = shoppingCartService.findByUserId(request.get("userId"));
        return cart.getTotal().doubleValue();
    }

    @PostMapping("addBook")
    @ResponseStatus(HttpStatus.OK)
    public void addBookToCart(@RequestBody Map<String, String> request) {
        ShoppingCart cart = shoppingCartService.findByUserId(request.get("userId"));
        Book book = bookService.findById(request.get("bookId"));
        ShoppingCart newCart = shoppingCartService.addBookToCart(cart, book);
        shoppingCartService.update(newCart);
    }

    @PostMapping("removeBook")
    public void removeFromCart(@RequestBody Map<String , String> request) {
        ShoppingCart cart = shoppingCartService.findByUserId(request.get("userId"));
        ShoppingCart newCart = shoppingCartService.removeBookFromCart(cart, request.get("bookId"));
        shoppingCartService.update(newCart);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingCart createCart(@RequestBody ShoppingCart cart) {
        cart.setId(UUID.randomUUID().toString().substring(0, 4));
        return shoppingCartService.update(cart);
    }

    @GetMapping
    public List<ShoppingCart> findAll() {
        return shoppingCartService.findAll();
    }

    @PutMapping("{id}")
    public ShoppingCart updateCart(@RequestBody ShoppingCart cart, @PathVariable String id) {
        return shoppingCartService.update(cart);
    }

}
