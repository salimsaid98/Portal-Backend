package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.exception.Datanotfound;
import com.example.demo.repository.UserRepo;


@Service
public class UserService {
    
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo){
            this.userRepo = userRepo;

    }

    public List<User> getUsers(){
            return StreamSupport.stream(userRepo.findAll().spliterator(),false).
             collect(Collectors.toList());
    }

    public User save(User user){
        return userRepo.save(user);
    }

    public User getUser(Long id){
        return userRepo.findById(id).orElseThrow(()-> new Datanotfound(id));
    }

    public User delete(Long id){
        User user = getUser(id);
        userRepo.delete(user);
        return user;
    }

    public User edit(Long id ,User user){
        User user2 = getUser(id);
        user2.setUsername(user.getUsername());
        user2.setEmail(user.getEmail());
        user2.setPhone(user.getPhone());
        user2.setPassword(user.getPassword());
            return userRepo.save(user2);
    }





}
