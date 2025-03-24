package com.example.jeera.service;

import com.example.jeera.entities.Board;
import com.example.jeera.entities.Project;
import com.example.jeera.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final SprintService sprintService;

    @Override
    public Board createBoardFromProject(Project newProject) {
      Board board = new Board();
      board.setProject(newProject);
      board.setName(String.format("%s Board", newProject.getName()));
      board.setSlug(newProject.getName().toLowerCase().replace(" ", "-"));

      Board savedBoard = boardRepository.save(board);
      sprintService.createSprintForBoard(savedBoard);
      return savedBoard;
    }
}
