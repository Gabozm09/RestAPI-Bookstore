package com.example.demo.domain.ShoppingCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartUser {
    private  int id;
    private String  first;
    private String last;
    private String email;
}
