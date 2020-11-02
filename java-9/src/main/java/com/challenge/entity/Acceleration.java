package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Acceleration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @ManyToOne
    private Challenge challenge;

    @NotNull
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "id.acceleration")
    private List<Candidate> candidates;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
