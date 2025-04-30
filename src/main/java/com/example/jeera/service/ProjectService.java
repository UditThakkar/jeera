package com.example.jeera.service;

import com.example.jeera.entities.Project;
import com.example.jeera.entities.User;
import com.example.jeera.dto.request.CreateProjectRequest;
import com.example.jeera.dto.response.ProjectCreationResponse;
import com.example.jeera.dto.response.ProjectResponseDto;

import java.util.List;

public interface ProjectService {
  ProjectCreationResponse createProject(CreateProjectRequest project, String email);

  Project getProject(Long id);

  List<Project> getProjectsByUserId(User user);

  Project updateProject(Long id, Project project);

  void deleteProject(Long id);

  List<ProjectResponseDto> getProjects(String email);
}
