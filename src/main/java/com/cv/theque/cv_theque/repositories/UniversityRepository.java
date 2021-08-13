package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Diploma;
import com.cv.theque.cv_theque.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findAllByDeletedIsFalse();
}
