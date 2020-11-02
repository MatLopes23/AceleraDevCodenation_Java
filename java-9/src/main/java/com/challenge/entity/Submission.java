package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Submission {

    @EmbeddedId
    private SubmissionIdentity submissionIdentity;

    @NotNull
    private float score;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    public SubmissionIdentity getSubmissionIdentity() {
        return submissionIdentity;
    }

    public void setSubmissionIdentity(SubmissionIdentity submissionIdentity) {
        this.submissionIdentity = submissionIdentity;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
