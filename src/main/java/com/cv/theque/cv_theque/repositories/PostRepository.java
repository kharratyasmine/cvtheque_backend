package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Candidature_Steps;
import com.cv.theque.cv_theque.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByDeletedIsFalse();

    @Query(value = "SELECT * FROM post p, candidature c, announcement a  WHERE c.id = ?1 and c.candidate_id = ?2 " +
            "and c.id_announcement = a.id_announcement and p.id_post = a.post_id and p.deleted = false",
            nativeQuery = true)
    Post findPostByCandidatureId(Long idCandidature, Long idCandidate);
}
