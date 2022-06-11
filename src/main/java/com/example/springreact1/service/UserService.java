package com.example.springreact1.service;

import com.example.springreact1.domain.User;
import com.example.springreact1.domain.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public void signup(String username, String password) {
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        userRepository.save(new User(username, encodedPassword, "USER"));
    }
}
