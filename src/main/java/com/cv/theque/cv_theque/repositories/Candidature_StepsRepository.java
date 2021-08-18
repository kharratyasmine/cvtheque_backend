package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Candidature_Steps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface Candidature_StepsRepository extends JpaRepository<Candidature_Steps, Long> {
    List<Candidature_Steps> findAllByDeletedIsFalse();

    @Query(value = "SELECT * FROM candidature_steps cs, candidature c  WHERE c.id = ?1 and c.candidate_id = ?2 and cs.id = c.id and cs.deleted = false ",
            nativeQuery = true)
    Collection<Candidature_Steps> findAllCandidature_Candidate(Long idCandidature, Long idCandidate);
    @Query(value = "SELECT count(*) FROM candidature_steps WHERE status = 'En cours' and deleted = false",
            nativeQuery = true)
    long countCandidature();
    @Query(value = "SELECT count(*) FROM candidature_steps WHERE sequence = 'Entretien Technique' and deleted = false",
            nativeQuery = true)
    long countCandidature1();
}
