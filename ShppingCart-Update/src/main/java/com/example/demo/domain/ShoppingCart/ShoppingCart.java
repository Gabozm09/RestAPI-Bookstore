package com.example.demo.domain.ShoppingCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCart {

    private BigDecimal subtotal = BigDecimal.ZERO ,total = BigDecimal.ZERO;
    private double taxRate;
    private int itemCount;
    private ShoppingCartUser user;

    private List<Book> bookList = new ArrayList<>();


    public void addBookToCart(Book book){
        itemCount++;
        updateSubtotal(book.getPrice(), true);
        updateTotal();
        bookList.add(book);
    }
    public void removeBookFromCart(int id){
        Book  bookToDelete  = null;
        for(Book current : bookList){
           if( current.getId() == id)
               bookToDelete = current;
        }
        itemCount--;
        updateSubtotal(bookToDelete.getPrice() , false);
        updateTotal();
        bookList.remove(bookToDelete);
    }
    private void updateTotal(){
         total = BigDecimal.valueOf(taxRate)
                .multiply(subtotal)
                .add(subtotal)
                .setScale(2 , RoundingMode.CEILING);
    }
    private void updateSubtotal(double price , boolean adding){
        if(adding)
           subtotal = subtotal.add(BigDecimal.valueOf(price)).setScale(2 , RoundingMode.CEILING);
        else
           subtotal = subtotal.subtract(BigDecimal.valueOf(price)).setScale(2 , RoundingMode.CEILING);

    }



}
