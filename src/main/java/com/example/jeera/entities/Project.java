package com.example.jeera.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private String category;
  private String slug;

  private List<String> tags = new ArrayList<>();

  @ManyToOne
  private User owner;

  @ManyToMany
  private List<User> members = new ArrayList<>();
}
