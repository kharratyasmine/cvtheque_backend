package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Candidature;
import com.cv.theque.cv_theque.models.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    List<Competence> findAllByDeletedIsFalse();
}

