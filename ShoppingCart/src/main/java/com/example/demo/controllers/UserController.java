package com.example.demo.controllers;

import com.example.demo.service.UserService;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("users/")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    public List<User> findAll(){
       return service.findAllUsers();
    }
    @GetMapping("{id}")
    public User findById(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        user.setId(UUID.randomUUID().toString().substring(0 ,4));
        return service.create(user);
    }

    @PutMapping
    public void update(@RequestBody User user){
         service.update(user);
    }


}
