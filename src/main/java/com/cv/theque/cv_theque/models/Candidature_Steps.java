package com.cv.theque.cv_theque.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Candidature_Steps extends Auditable<String> {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_candidature_steps;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", nullable = false)
    @JsonIgnoreProperties(allowSetters = true, value = {"candidature_steps", "hibernateLazyInitializer"})
    private Candidature candidature;
    private String sequence;
    private String step_description;
    private String planned_date;
    private String status;

    public long getId_candidature_steps() {
        return id_candidature_steps;
    }

    public void setId_candidature_steps(long id_candidature_steps) {
        this.id_candidature_steps = id_candidature_steps;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getStep_description() {
        return step_description;
    }

    public void setStep_description(String step_description) {
        this.step_description = step_description;
    }

    public String getPlanned_date() {
        return planned_date;
    }

    public void setPlanned_date(String planned_date) {
        this.planned_date = planned_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Candidature_Steps{" +
                "id_candidature_steps=" + id_candidature_steps +
                ", candidature=" + candidature +
                ", sequence='" + sequence + '\'' +
                ", step_description='" + step_description + '\'' +
                ", planned_date='" + planned_date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
