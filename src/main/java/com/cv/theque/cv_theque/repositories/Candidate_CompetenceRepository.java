package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Candidate_Advantage;
import com.cv.theque.cv_theque.models.Candidate_Competence;
import com.cv.theque.cv_theque.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Candidate_CompetenceRepository extends JpaRepository<Candidate_Competence, Long> {
    List<Candidate_Competence> findAllByDeletedIsFalse();
    @Query(value = "SELECT * FROM candidate_competence c, candidature ca  WHERE ca.id = ?1 and c.candidate_id = ?2 and ca.candidate_id= c.candidate_id" +
            " and c.candidature_id = ca.id" +
            " and c.deleted = false",
            nativeQuery = true)
    List<Candidate_Competence> findCompetenceByCandidatureId(Long idCandidature, Long idCandidate);
}
