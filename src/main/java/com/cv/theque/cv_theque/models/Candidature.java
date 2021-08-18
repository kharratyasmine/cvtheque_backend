package com.cv.theque.cv_theque.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="candidate_id")
public class Candidature extends Auditable<String>  {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonIgnore
    @OneToMany(mappedBy = "candidature")
    private List<Candidature_Steps> candidature_steps;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    @JsonIgnoreProperties(value = {"candidatures", "hibernateLazyInitializer"})
    private Candidate candidate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_announcement", nullable = false)
    @JsonIgnoreProperties(value = {"candidatures", "hibernateLazyInitializer"})
    private Announcement announcement;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Candidature_Steps> getCandidature_steps() {
        return candidature_steps;
    }

    public void setCandidature_steps(List<Candidature_Steps> candidature_steps) {
        this.candidature_steps = candidature_steps;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Candidature() {
    }

    @Override
    public String toString() {
        return "Candidature{" +
                "id=" + id +
                ", candidature_steps=" + candidature_steps +
                ", candidate=" + candidate +
                ", announcement=" + announcement +
                '}';
    }
}

