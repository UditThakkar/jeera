package com.example.jeera.response;

import com.example.jeera.entities.Board;
import com.example.jeera.entities.Project;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class ProjectCreationResponse {
  private Data data;

  @Builder
  @Getter
  @Setter
  public static class Data {
    private ProjectDto project;
    private Board board;
  }

  @Builder
  @Getter
  @Setter
  public static class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String tags;
    private Owner owner;
  }

  @Builder
  @Getter
  @Setter
  public static class Owner {
    private Long id;
  }
}
