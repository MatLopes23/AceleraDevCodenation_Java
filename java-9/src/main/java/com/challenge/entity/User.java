package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String full_name;

    @NotNull
    @NotBlank
    @Email
    @Size(max = 100)
    @Column(length = 100)
    private String email;

    @NotBlank
    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String nick_name;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String password;

    @NotNull
    @CreatedDate
    @Size(max = 255)
    @Column(name = "created_at")
    private Date created_at;

    @OneToMany
    private List<Candidate> candidate;

    @OneToMany
    private List<Submission> submissions;


    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<Candidate> getCandidates() {
        return candidate;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidate = candidates;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

}
