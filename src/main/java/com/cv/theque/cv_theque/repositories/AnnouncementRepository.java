package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Advantage;
import com.cv.theque.cv_theque.models.Announcement;
import com.cv.theque.cv_theque.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findAllByDeletedIsFalse();
    Announcement findByPost(Post post);
}
