package com.example.jeera.controller;

import com.example.jeera.entities.User;
import com.example.jeera.request.CreateProjectRequest;
import com.example.jeera.response.ProjectCreationResponse;
import com.example.jeera.service.ProjectService;
import com.example.jeera.utils.JwtHelper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProjectController {

  private final ProjectService projectService;

  @PostMapping("/project")
  public ResponseEntity<ProjectCreationResponse> createProject(@RequestBody CreateProjectRequest request, HttpServletRequest req) {
    String email = JwtHelper.getUserFromJwt(req);
    ProjectCreationResponse response = projectService.createProject(request, email);
    return ResponseEntity.ok(response);
  }
}
