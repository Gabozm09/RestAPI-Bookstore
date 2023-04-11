package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.ShoppingCart;
import com.example.demo.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    ShoppingCartRepository repository;

  public ShoppingCart findByUserId(String userId){
        return repository.findByUserId(userId);
    }

   public ShoppingCart update(ShoppingCart shoppingCart){
       return repository.save(shoppingCart);
    }
   public void delete(ShoppingCart shoppingCart){
        repository.delete(shoppingCart);
    }
    public List<ShoppingCart> findAll(){
      return repository.findAll();
    }


    public ShoppingCart removeBookFromCart(ShoppingCart cart ,String id){
        Book bookToDelete  = null;
        for(Book current : cart.getBookList()){
            if( current.getId().equals( id))
                bookToDelete = current;
        }
        cart.setItemCount(cart.getItemCount()- 1);;
        cart.updateSubtotal(bookToDelete.getPrice() , false);
        cart.updateTotal();
        cart.getBookList().remove(bookToDelete);
        return cart;
    }

    public ShoppingCart addBookToCart(ShoppingCart cart ,Book book){
      cart.setItemCount(cart.getItemCount()+1);
      cart.updateSubtotal(book.getPrice(), true);
      cart.updateTotal();
      cart.getBookList().add(book);
      return cart;
    }
}
