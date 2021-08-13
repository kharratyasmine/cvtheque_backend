package com.cv.theque.cv_theque.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<T> {

    @LastModifiedDate
    private T last_modified_date;
    @LastModifiedBy
    private T last_modified_by;
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private T created_date;
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private T created_by;
    private boolean deleted;

    public T getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(T last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public T getCreated_date() {
        return created_date;
    }

    public void setCreated_date(T created_date) {
        this.created_date = created_date;
    }

    public T getLast_modified_by() {
        return last_modified_by;
    }

    public T getCreated_by() {
        return created_by;
    }

    public void setCreated_by(T created_by) {
        this.created_by = created_by;
    }

    public void setLast_modified_by(T last_modified_by) {
        this.last_modified_by = last_modified_by;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
