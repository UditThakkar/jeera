package com.example.jeera.utils;

import com.example.jeera.config.JwtProvider;
import com.example.jeera.entities.User;
import com.example.jeera.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

public class JwtHelper {

  public static String getUserFromJwt(HttpServletRequest req) {
    String jwt = req.getHeader("Authorization");
    if (jwt != null && jwt.startsWith("Bearer ")) {
      jwt = jwt.substring(7);
    }
    return JwtProvider.getEmailFromJwtToken(jwt);
  }
}
