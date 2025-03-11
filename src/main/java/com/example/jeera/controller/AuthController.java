package com.example.jeera.controller;

import com.example.jeera.entities.User;
import com.example.jeera.repository.UserRepository;
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

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService customUserDetails;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new Exception("User already exists");
        } else {
            User createdUser = new User();
            createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
            createdUser.setEmail(user.getEmail());
            createdUser.setFullName(user.getFullName());

            User savedUser = userRepository.save(createdUser);

            return ResponseEntity.ok(savedUser);
        }
    }
}
