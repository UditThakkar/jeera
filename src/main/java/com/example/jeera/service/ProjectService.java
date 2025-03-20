package com.example.jeera.service;

import com.example.jeera.entities.Project;
import com.example.jeera.entities.User;

import java.util.List;

public interface ProjectService {
  Project createProject(Project project);

  Project getProject(Long id);

  List<Project> getProjectsByUserId(User user);

  Project updateProject(Long id, Project project);

  void deleteProject(Long id);
}
