package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.models.Candidature_Steps;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query(value = "SELECT * FROM  candidate c WHERE c.deleted = false",
            nativeQuery = true)
    List<Candidate> findAllWithoutCV();

    @Query(value = "SELECT  cv FROM  candidate c WHERE c.candidate_id = ?1",
            nativeQuery = true)
    String findCvByCandidateId(Long id_candidate);


}
