package com.example.jeera.controller;

import com.example.jeera.dto.request.CreateProjectRequest;
import com.example.jeera.dto.response.ProjectCreationResponse;
import com.example.jeera.dto.response.ProjectResponseDto;
import com.example.jeera.service.ProjectService;
import com.example.jeera.utils.JwtHelper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

  @GetMapping("/projects")
  public ResponseEntity<List<ProjectResponseDto>> getProjects(HttpServletRequest req) {
    String email = JwtHelper.getUserFromJwt(req);
    List<ProjectResponseDto> projects = projectService.getProjects(email);
    return ResponseEntity.ok(projects);
  }
}
