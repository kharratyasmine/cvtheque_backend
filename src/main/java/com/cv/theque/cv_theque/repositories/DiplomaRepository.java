package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Long> {
    List<Diploma> findAllByDeletedIsFalse();
}
