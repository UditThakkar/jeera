package com.example.jeera.controller;

import com.example.jeera.entities.User;
import com.example.jeera.repository.UserRepository;
import com.example.jeera.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        User createdUser = userService.registerUser(user);

        return ResponseEntity.ok(createdUser);
    }
}
