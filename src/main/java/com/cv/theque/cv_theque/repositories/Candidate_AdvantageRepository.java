package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Advantage;
import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.models.Candidate_Advantage;
import com.cv.theque.cv_theque.models.Candidate_Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Candidate_AdvantageRepository extends JpaRepository<Candidate_Advantage, Long> {
    List<Candidate_Advantage> findAllByDeletedIsFalse();
    @Query(value = "SELECT * FROM candidate_advantage c, candidature ca  WHERE ca.id = ?1 and c.candidate_id = ?2 and ca.candidate_id= c.candidate_id" +
            " and c.deleted = false and c.candidature_id = ca.id",
            nativeQuery = true)
    List<Candidate_Advantage> findAdvantageByCandidatureId(Long idCandidature, Long idCandidate);
}
