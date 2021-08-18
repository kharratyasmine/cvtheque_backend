package com.cv.theque.cv_theque.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity()
public class Candidate_Advantage extends Auditable<String> {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long candidate_advantage_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    @JsonIgnoreProperties(allowSetters = true, value = {"candidate_advantages", "hibernateLazyInitializer"})
    private Candidate candidate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_advantage", nullable = false)
    @JsonIgnoreProperties(value = {"candidate_advantages", "hibernateLazyInitializer"})
    private Advantage advantage;
    private String evaluation;
    private Long candidatureId;

    public Long getCandidatureId() {
        return candidatureId;
    }

    public void setCandidatureId(Long candidatureId) {
        this.candidatureId = candidatureId;
    }

    public long getCandidate_advantage_id() {
        return candidate_advantage_id;
    }

    public void setAdvantage_id(long advantage_id) {
        this.candidate_advantage_id = advantage_id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidat) {
        this.candidate = candidat;
    }

    public Advantage getAdvantage() {
        return advantage;
    }

    public void setAdvantage(Advantage advantage) {
        this.advantage = advantage;
    }

    public void setCandidate_advantage_id(long candidate_advantage_id) {
        this.candidate_advantage_id = candidate_advantage_id;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "Candidate_Advantage{" +
                "candidate_advantage_id=" + candidate_advantage_id +
                ", candidate=" + candidate +
                ", advantage=" + advantage +
                ", evaluation='" + evaluation + '\'' +
                '}';
    }
}
