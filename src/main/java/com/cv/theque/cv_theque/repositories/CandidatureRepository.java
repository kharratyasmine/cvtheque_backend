package com.cv.theque.cv_theque.repositories;
import com.cv.theque.cv_theque.models.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
    List<Candidature> findAllByDeletedIsFalse();

    @Query(value = "SELECT * FROM  candidature c  WHERE c.candidate_id = ?1 and c.deleted = false",
            nativeQuery = true)
    List<Candidature> findCandidature(Long candidate_id);
    @Query(value = "SELECT * FROM  candidature c, announcement a, post p WHERE c.id_announcement = a.id_announcement and p.id_post = a.post_id and c.deleted = false",
            nativeQuery = true)
    long countCandidature();

    @Query(value = "SELECT * FROM  candidature c, announcement a, post p WHERE c.id_announcement = a.id_announcement and p.id_post = a.post_id " +
            "and p.id_post = ?1 and c.deleted = false",
            nativeQuery = true)
    List<Candidature> countCandidatureByPost(Long postName);
}
