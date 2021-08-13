package com.cv.theque.cv_theque.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity()
public class Announcement extends Auditable<String> {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_announcement;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnoreProperties(value = {"announcement", "hibernateLazyInitializer"})
    private Post post;
    private String description;

    public long getId_announcement() {
        return id_announcement;
    }

    public void setId_announcement(long id_announcement) {
        this.id_announcement = id_announcement;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id_announcement=" + id_announcement +
                ", post=" + post +
                ", description='" + description + '\'' +
                '}';
    }
}
