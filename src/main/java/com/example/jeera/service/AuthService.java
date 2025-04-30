package com.example.jeera.service;

import com.example.jeera.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(String username, String password);
}
