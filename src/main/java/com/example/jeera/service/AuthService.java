package com.example.jeera.service;

import com.example.jeera.response.AuthResponse;

public interface AuthService {
    AuthResponse login(String username, String password);
}
