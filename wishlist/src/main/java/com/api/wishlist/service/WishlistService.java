package com.api.wishlist.service;

import com.api.wishlist.controller.WishlistNotFoundException;
import com.api.wishlist.model.Wishlist;
import com.api.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist createWishlist(String userId, String name) {
        Wishlist wishlist = new Wishlist(null, userId, name, new ArrayList<>());
        return wishlistRepository.save(wishlist);
    }

    public void addBookToWishlist(String wishlistId, String bookId) throws WishlistNotFoundException {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new WishlistNotFoundException("Wishlist not found with id " + wishlistId));

        wishlist.getBookIds().add(bookId);
        wishlistRepository.save(wishlist);
    }

    public void removeBookFromWishlist(String wishlistId, String bookId) throws WishlistNotFoundException {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new WishlistNotFoundException("Wishlist not found with id " + wishlistId));

        wishlist.getBookIds().remove(bookId);
        wishlistRepository.save(wishlist);
    }

    public List<String> getBooksInWishlist(String wishlistId) throws WishlistNotFoundException {
        Wishlist wishlist = wishlistRepository.findById(wishlistId)
                .orElseThrow(() -> new WishlistNotFoundException("Wishlist not found with id " + wishlistId));

        return wishlist.getBookIds();
    }
}