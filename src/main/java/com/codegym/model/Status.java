package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private User user;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Set<UsedImage> usedImageSet;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Set<Liked> likedSet;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Set<Comment> commentSet;
    private LocalDateTime createAt = LocalDateTime.now();
}
