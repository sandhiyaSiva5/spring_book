package com.example.springbooks.service;

import com.example.springbooks.model.User; // Import User entity class
import com.example.springbooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import java.util.List; // Import List class\
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
//        List<User> allUsers = userRepository.findAll();
//        boolean userexist = false;
//        User existingUser = null;
//        for (User x : allUsers) {
//            if (x.getName().equals(user.getName())) {
//                userexist = true;
//                existingUser = x;
//                break;
//            }
//        }
//        if(userexist){
//            return existingUser;
//        }
//        else{
//            return userRepository.save(user);
//        }

        Optional userExist = userRepository.findByName(user.getName());
        if(userExist.isPresent()){
            return userExist.get();
        }
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).get(); // Use orElse(null) to handle optional
    }

    public List<User> getAllUsers() { // Corrected method name to follow Java naming convention
        return userRepository.findAll();
    }
}