package com.example.springreact1.web;

import com.example.springreact1.domain.Car;
import com.example.springreact1.domain.CarRepository;
import com.example.springreact1.domain.UserRepository;
import com.example.springreact1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public HttpStatus getCars(@RequestBody UserCredentialsDTO userCredentialsDTO){
        userService.signup(userCredentialsDTO.getUsername(), userCredentialsDTO.getPassword());
        return HttpStatus.OK;
    }
}
