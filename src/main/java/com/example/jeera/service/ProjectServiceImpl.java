package com.example.jeera.service;

import com.example.jeera.entities.Board;
import com.example.jeera.entities.Project;
import com.example.jeera.entities.User;
import com.example.jeera.repository.ProjectRepository;
import com.example.jeera.repository.UserRepository;
import com.example.jeera.request.CreateProjectRequest;
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
  private final UserRepository userRepository;

  @Override
  public ProjectCreationResponse createProject(CreateProjectRequest project, String email) {
    Project newProject = Project.builder()
        .name(project.getName())
        .description(project.getDescription())
            .category(project.getCategory())
            .tags(project.getTags())
            .owner(userRepository.findByEmail(email))
        .build();
    projectRepository.save(newProject);
    Board board = boardService.createBoardFromProject(newProject);

    return ProjectCreationResponse.builder()
        .data(ProjectCreationResponse.Data.builder()
            .project(ProjectCreationResponse.ProjectDto.builder()
                .id(newProject.getId())
                .name(newProject.getName())
                .description(newProject.getDescription())
                .category(newProject.getCategory())
                .tags(String.join(", ", newProject.getTags()))
                .owner(ProjectCreationResponse.Owner.builder()
                    .id(newProject.getOwner().getId())
                    .build())
                .build())
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
