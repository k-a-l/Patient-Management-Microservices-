package com.kalyan.authservice.service;

import com.kalyan.authservice.repository.UserRepository;
import com.kalyan.authservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);

    }
}
