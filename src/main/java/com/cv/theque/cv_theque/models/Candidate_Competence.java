package com.cv.theque.cv_theque.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity()
public class Candidate_Competence extends Auditable<String>  {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_candidate_competence;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    @JsonIgnoreProperties(allowSetters = true, value = {"candidate_competences", "hibernateLazyInitializer"})
    private Candidate candidate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_competence", nullable = false)
    @JsonIgnoreProperties(allowSetters = true, value = {"candidate_competences", "hibernateLazyInitializer"})
    private Competence competence;
    private Long candidatureId;
    private int evaluation;

    public Long getCandidatureId() {
        return candidatureId;
    }

    public void setCandidatureId(Long candidatureId) {
        this.candidatureId = candidatureId;
    }

    public long getId_candidate_competence() {
        return id_candidate_competence;
    }

    public void setId_candidate_competence(long id_candidate_competence) {
        this.id_candidate_competence = id_candidate_competence;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }
    @Override
    public java.lang.String toString() {
        return "Candidate_Competence{" +
                "id_candidate_competence=" + id_candidate_competence +
                ", candidate=" + candidate +
                ", competence=" + competence +
                ", evaluation=" + evaluation +
                '}';
    }
}
