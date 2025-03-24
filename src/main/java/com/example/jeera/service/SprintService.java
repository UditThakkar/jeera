package com.example.jeera.service;

import com.example.jeera.entities.Board;
import com.example.jeera.entities.Project;
import com.example.jeera.entities.Sprint;

public interface SprintService {
  Sprint createSprintForBoard(Board board);
}
