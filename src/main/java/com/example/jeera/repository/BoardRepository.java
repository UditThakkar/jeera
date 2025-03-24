package com.example.jeera.repository;

import com.example.jeera.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
