package com.cv.theque.cv_theque.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University extends Auditable<String>  {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long university_id;
    private String name;
    private String description;

    public long getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(long university_id) {
        this.university_id = university_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
