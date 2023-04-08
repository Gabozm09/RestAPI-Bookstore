package com.example.demo;

import com.example.demo.controllers.ShoppingCartController;
import com.example.demo.domain.ShoppingCart.Book;
import com.example.demo.domain.ShoppingCart.Genre;
import com.example.demo.domain.ShoppingCart.ShoppingCart;
import com.example.demo.domain.ShoppingCart.ShoppingCartUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {
 static ShoppingCartController cartController;
 static ShoppingCart cart;
	public static void main(String[] args) {
		cart = new ShoppingCart();
		cartController = new ShoppingCartController(cart);
		Book gameOfThrones = new Book("Game of Thrones", 12.99, 1 , Genre.FICTION);
		Book harryPotter = new Book("Harry Potter", 20.99, 2 , Genre.FICTION);
		Book bible = new Book("Bible", 20.99, 3 , Genre.HISTORY);
		Book MasterYourEmotions = new Book("Master Your Emotions", 21.99, 4 , Genre.SELF_HELP);
		cart.setTaxRate(.07);
		ShoppingCartUser matt = new ShoppingCartUser(1 , "Matt", "Wright", "mwrig067@fiu.edu");
		cart.setUser(matt);

		cart.addBookToCart(gameOfThrones);
		cart.addBookToCart(harryPotter);
		cart.addBookToCart(bible);




		SpringApplication.run(DemoApplication.class, args);

	}




}
