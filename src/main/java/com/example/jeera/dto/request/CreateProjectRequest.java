package com.example.jeera.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectRequest {

  private String name;
  private String description;
  private String category;
  private List<String> tags;
}
