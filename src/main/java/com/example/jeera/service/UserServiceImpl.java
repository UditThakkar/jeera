package com.example.jeera.service;

import com.example.jeera.entities.User;
import com.example.jeera.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public User getuser(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public User registerUser(User user) {
    if(getuser(user.getEmail()) != null){
      throw new RuntimeException("User already exists");
    }
    User createdUser = new User();
    createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
    createdUser.setEmail(user.getEmail());
    createdUser.setFullName(user.getFullName());

    return userRepository.save(createdUser);
  }
}
