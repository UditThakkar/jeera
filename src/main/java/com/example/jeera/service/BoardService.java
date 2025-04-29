package com.example.jeera.service;

import com.example.jeera.entities.Board;
import com.example.jeera.entities.Project;

public interface BoardService {
  Board createBoardFromProject(Project project);
}
