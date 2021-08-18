package com.cv.theque.cv_theque.repositories;

import com.cv.theque.cv_theque.models.Advantage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvantageRepository extends JpaRepository<Advantage, Long> {
    List<Advantage> findAllByDeletedIsFalse();
}
