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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    @OneToMany
    private List<Candidate> canditate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<Candidate> getCanditate() {
        return canditate;
    }

    public void setCanditate(List<Candidate> canditate) {
        this.canditate = canditate;
    }
}
