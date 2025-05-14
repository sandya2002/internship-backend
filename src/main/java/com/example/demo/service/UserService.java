package com.example.demo.service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public User User (User user) {
//        return userRepository.save(user);
//    }
    public User signup(com.example.demo.model.User user) {
		return userRepository.save(user);
	}

    public User login(String email) {
        return userRepository.findByEmail(email);
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
    
