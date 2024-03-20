package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Column(columnDefinition = "TEXT")
    private String content;
    private final LocalDateTime createAt = LocalDateTime.now();
}