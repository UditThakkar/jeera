package com.example.jeera.service;

import com.example.jeera.entities.Board;
import com.example.jeera.entities.Project;
import com.example.jeera.entities.User;
import com.example.jeera.repository.ProjectRepository;
import com.example.jeera.response.ProjectCreationResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService{

  private final ProjectRepository projectRepository;
  private final BoardService boardService;

  @Override
  public ProjectCreationResponse createProject(Project project) {
    Project newProject = projectRepository.save(project);
    Board board = boardService.createBoardFromProject(newProject);

    return ProjectCreationResponse.builder()
        .data(ProjectCreationResponse.Data.builder()
            .project(newProject)
            .board(board)
            .build())
        .build();
  }

  @Override
  public Project getProject(Long id) {
    return projectRepository.findById(id).orElse(null);
  }

  @Override
  public List<Project> getProjectsByUserId(User user) {
    return projectRepository.findAllByOwner(user);
  }

  @Override
  public Project updateProject(Long id, Project project) {
    return null;
  }

  @Override
  public void deleteProject(Long id) {

  }
}
