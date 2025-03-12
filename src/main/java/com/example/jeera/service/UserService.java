package com.example.jeera.service;

import com.example.jeera.entities.User;

public interface UserService {
  User getuser(String email);

  User registerUser(User user);
}
