package com.cv.theque.cv_theque.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Diploma extends Auditable<String>  {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long diploma_id;
    private String name;
    private Date diploma_date;

    public long getDiploma_id() {
        return diploma_id;
    }

    public void setDiploma_id(long diploma_id) {
        this.diploma_id = diploma_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDiploma_date() {
        return diploma_date;
    }

    public void setDiploma_date(Date diploma_date) {
        this.diploma_date = diploma_date;
    }
}
