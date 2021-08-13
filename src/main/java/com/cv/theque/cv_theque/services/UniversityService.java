package com.cv.theque.cv_theque.services;
import com.cv.theque.cv_theque.models.University;
import com.cv.theque.cv_theque.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final  UniversityRepository UniversityRepository;

    public UniversityService(UniversityRepository UniversityRepository) {
        this.UniversityRepository = UniversityRepository;
    }

    public List<University> findAllUniversities() {
        return UniversityRepository.findAllByDeletedIsFalse();
    }

    public University putUniversity(University University, Long id) {
        University.setUniversity_id(id);
        return UniversityRepository.save(University);
    }

    public University deleteUniversity(Long id) {
        University University = findUniversityById(id);
        University.setDeleted(true);
        return putUniversity(University, id);
    }

    public University addUniversity(University University) {
        return UniversityRepository.save(University);
    }

    public University findUniversityById(Long id) {
        return UniversityRepository.findById(id).get();
    }
}
