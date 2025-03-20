package com.example.jeera.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private LocalDateTime startDate;
  private int duration;
  private String goal;
  private String slug;
  private boolean currentSprint;
  private boolean backlogSprint;
  private long totalStoryPoints;
  private long completedStoryPoints;


  @ManyToOne
  @JoinColumn(name = "board_id")
  private Board board;
}
