package com.challenge.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Candidate {

    @EmbeddedId
    private CandidateIdentity candidateIdentity;

    @NotNull
    private int status;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime created_at;

}
