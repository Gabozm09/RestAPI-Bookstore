package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User create( User user){
        return repository.save(user);
    }

    public void update(User user){
        repository.save(user);
    }

    public void delete(User user){
        repository.delete(user);
    }
    public User findById(String id){
        return repository.findById(id).get();
    }
    public List<User> findAllUsers(){
        return repository.findAll();
    }
}
