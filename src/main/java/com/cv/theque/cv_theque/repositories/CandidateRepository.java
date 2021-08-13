package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.models.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findAllByDeletedIsFalse();
    @Query(value = "SELECT count(*) FROM  candidate c WHERE c.deleted = false",
            nativeQuery = true)
     long countCandidate();
}
