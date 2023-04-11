package com.example.OneToOne17.controller;

import com.example.OneToOne17.entity.User;
import com.example.OneToOne17.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired private UserService userService;

    //Save Operation
    @PostMapping("/users")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    //Read Operation
    @GetMapping("/users")
    public List<User> fetchUserList()
    {
        return userService.fetchUserList();
    }

    // Update Operation
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id)
    {
        return userService.updateUser(
                user, id);
    }

    //Delete Operation
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long id)
    {
        userService.deleteUserById(id);
        return "Deleted Successfully";
    }
}