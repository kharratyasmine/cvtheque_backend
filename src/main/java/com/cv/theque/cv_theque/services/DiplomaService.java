package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Announcement;
import com.cv.theque.cv_theque.models.Diploma;
import com.cv.theque.cv_theque.repositories.DiplomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomaService {

    private final DiplomaRepository diplomaRepository;

    public DiplomaService(DiplomaRepository DiplomaRepository) {
        this.diplomaRepository = DiplomaRepository;
    }

    public List<Diploma> findAllDiplomas() {
        return diplomaRepository.findAllByDeletedIsFalse();
    }

    public Diploma putDiploma(Diploma Diploma, Long id) {
        Diploma.setDiploma_id(id);
        return diplomaRepository.save(Diploma);
    }

    public Diploma deleteDiploma(Long id) {
        Diploma diploma = findDiplomaById(id);
        diploma.setDeleted(true);
        return putDiploma(diploma, id);
    }

    public Diploma addDiploma(Diploma Diploma) {
        return diplomaRepository.save(Diploma);
    }

    public Diploma findDiplomaById(Long id) {
        return diplomaRepository.findById(id).get();
    }
}
