package com.cv.theque.cv_theque.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post extends Auditable<String> {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_post;
    private String post_name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId_post() {
        return id_post;
    }

    public void setId_post(long id_post) {
        this.id_post = id_post;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id_post=" + id_post +
                ", post_name='" + post_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
