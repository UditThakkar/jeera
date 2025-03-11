package com.example.jeera.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignee;
}
