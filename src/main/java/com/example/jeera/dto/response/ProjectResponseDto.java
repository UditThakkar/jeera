package com.example.jeera.dto.response;

import java.util.*;

import com.example.jeera.entities.Project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProjectResponseDto {
  private Long id;
  private String name;
  private String description;
  private String category;
  private String tags;
  private Owner owner;

  @Builder
  @Getter
  @Setter
  public static class Owner {
    private Long id;
  }
}
