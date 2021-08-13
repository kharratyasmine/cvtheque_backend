package com.cv.theque.cv_theque.models;

import javax.persistence.*;

@Entity
public class Competence extends Auditable<String>{
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_competence;
    private String competence_name;
    private String competence_group;

    public long getId_competence() {
        return id_competence;
    }

    public void setId_competence(long id_competence) {
        this.id_competence = id_competence;
    }

    public String getCompetence_name() {
        return competence_name;
    }

    public void setCompetence_name(String competence_name) {
        this.competence_name = competence_name;
    }

    public String getCompetence_group() {
        return competence_group;
    }

    public void setCompetence_group(String competence_group) {
        this.competence_group = competence_group;
    }

    public Competence() {
    }

    @Override
    public String toString() {
        return "Competence{" +
                "id=" + id_competence +
                ", competence_name='" + competence_name + '\'' +
                ", competence_group='" + competence_group + '\'' +
                '}';
    }
}
