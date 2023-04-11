package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@Document(collection="carts")
public class ShoppingCart {
    @Id
    private String id;
    private BigDecimal subtotal = BigDecimal.ZERO ,total = BigDecimal.ZERO;
    private double taxRate;
    private int itemCount;
    private String userId;

    private List<Book> bookList = new ArrayList<>();




    public void updateTotal(){
         total = BigDecimal.valueOf(taxRate)
                .multiply(subtotal)
                .add(subtotal)
                .setScale(2 , RoundingMode.CEILING);
    }
    public void updateSubtotal(double price, boolean adding){
        if(adding)
           subtotal = subtotal.add(BigDecimal.valueOf(price)).setScale(2 , RoundingMode.CEILING);
        else
           subtotal = subtotal.subtract(BigDecimal.valueOf(price)).setScale(2 , RoundingMode.CEILING);
    }



}
