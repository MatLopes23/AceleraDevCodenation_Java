package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(length = 100)
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Column(length = 50)
    @Size(max = 50)
    private String slug;

    @OneToMany
    private List<Acceleration> accelerations;

    @OneToMany
    private List<Submission> submissions;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

}
