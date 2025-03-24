package com.example.jeera.response;

import com.example.jeera.entities.Board;
import com.example.jeera.entities.Project;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectCreationResponse {
  private Data data;

  @Builder
  public static class Data {
    private Project project;
    private Board board;
  }
}
