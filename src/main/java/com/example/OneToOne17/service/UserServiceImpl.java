package com.example.OneToOne17.service;

import com.example.OneToOne17.entity.User;
import com.example.OneToOne17.repository.UserRepository;
import com.example.OneToOne17.resource.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
// Class implementing ProductService class
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Save operation
    @Override
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    //Read operation
    @Override
    public List<User> fetchUserList()
    {
        return userRepository.findAll();
    }

    //Update operation
    @Override
    public User updateUser(User user, Long id)
    {
        User userDB = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        userDB.setName(user.getName());
        userDB.setEmail(user.getEmail());
        userDB.setUserProfile(user.getUserProfile());

        return userRepository.save(userDB);
    }

    // Delete operation
    @Override
    public void deleteUserById(Long id)
    {
        userRepository.deleteById(id);
    }
}