package com.example.jeera.service;

import com.example.jeera.entities.Board;
import com.example.jeera.entities.Project;
import com.example.jeera.entities.Sprint;
import com.example.jeera.repository.SprintRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SprintServiceImpl implements SprintService {

  private SprintRepository sprintRepository;

  @Override
  public Sprint createSprintForBoard(Board board) {
    Sprint sprint = new Sprint();
    sprint.setBoard(board);
    sprint.setName("Backlog Sprint");
    sprint.setStartDate(LocalDateTime.now());
    sprint.setGoal("This is the backlog Sprint for this Board");
    sprint.setCurrentSprint(false);
    sprint.setBacklogSprint(true);

    return sprintRepository.save(sprint);
  }
}
