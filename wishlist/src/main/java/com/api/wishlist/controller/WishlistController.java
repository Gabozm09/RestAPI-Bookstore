package com.api.wishlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.wishlist.model.Wishlist;
import com.api.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    @PostMapping
    public ResponseEntity<Wishlist> createWishlist(@RequestParam String userId, @RequestParam String name) {
        Wishlist wishlist = wishlistService.createWishlist(userId, name);
        return new ResponseEntity<>(wishlist, HttpStatus.CREATED);
    }

    @PostMapping("/{wishlistId}/book/{bookId}")
    public ResponseEntity<Void> addBookToWishlist(@PathVariable String wishlistId, @PathVariable String bookId) throws WishlistNotFoundException {
        wishlistService.addBookToWishlist(wishlistId, bookId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{wishlistId}/book/{bookId}")
    public ResponseEntity<Void> removeBookFromWishlist(@PathVariable String wishlistId, @PathVariable String bookId) throws WishlistNotFoundException {
        wishlistService.removeBookFromWishlist(wishlistId, bookId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{wishlistId}")
    public ResponseEntity<List<String>> getBooksInWishlist(@PathVariable String wishlistId) throws WishlistNotFoundException {
        List<String> bookIds = wishlistService.getBooksInWishlist(wishlistId);
        return new ResponseEntity<>(bookIds, HttpStatus.OK);
    }
}
