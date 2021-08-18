package com.cv.theque.cv_theque.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity()
public class Advantage extends Auditable<String> {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_advantage;
    @JsonIgnore
    @OneToMany(mappedBy = "advantage")
    private List<Candidate_Advantage> candidate_Advantages;
    private String advantage_name;
    private String advantage_group;

    public long getId_advantage() {
        return id_advantage;
    }

    public List<Candidate_Advantage> getCandidate_Advantages() {
        return candidate_Advantages;
    }

    public void setCandidate_Advantages(List<Candidate_Advantage> candidate_Advantages) {
        candidate_Advantages = candidate_Advantages;
    }

    public void setId_advantage(long id_advantage) {
        this.id_advantage = id_advantage;
    }

    public String getAdvantage_name() {
        return advantage_name;
    }

    public void setAdvantage_name(String advantage_name) {
        this.advantage_name = advantage_name;
    }

    public String getAdvantage_group() {
        return advantage_group;
    }

    public void setAdvantage_group(String advantage_group) {
        this.advantage_group = advantage_group;
    }
    @Override
    public java.lang.String toString() {
        return "Advantage{" +
                "id_advantage=" + id_advantage +
                ", advantage_name='" + advantage_name + '\'' +
                ", advantage_group='" + advantage_group + '\'' +
                '}';
    }
}
