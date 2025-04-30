package com.example.jeera.dto.response;

import com.example.jeera.entities.Board;
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
    private ProjectResponseDto project;
    private Board board;
  }
}
