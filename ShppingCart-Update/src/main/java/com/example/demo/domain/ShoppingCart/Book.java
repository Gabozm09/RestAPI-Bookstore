package com.example.demo.domain.ShoppingCart;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private String title;
    private double price;
    private int id;
    private Genre genre;
}
