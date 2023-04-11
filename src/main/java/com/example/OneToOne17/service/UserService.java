package com.example.OneToOne17.service;

import com.example.OneToOne17.entity.User;

import java.util.List;

public interface UserService {

    // Save operation
    User saveUser(User user);

    //Read operation
    List<User> fetchUserList();

    //Update operation
    User updateUser(User user, Long id);

    //Delete operation
    void deleteUserById(Long id);

}
