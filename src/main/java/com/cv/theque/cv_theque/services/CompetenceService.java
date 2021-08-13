package com.cv.theque.cv_theque.services;
import com.cv.theque.cv_theque.models.Competence;
import com.cv.theque.cv_theque.repositories.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {

    private final CompetenceRepository CompetenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository) {
        this.CompetenceRepository = competenceRepository;
    }

    public List<Competence> findAllCompetences() {
        return CompetenceRepository.findAllByDeletedIsFalse();
    }

    public Competence putCompetence(Competence Competence, Long id) {
        Competence.setId_competence(id);
        return CompetenceRepository.save(Competence);
    }

    public Competence deleteCompetence(Long id) {
        Competence Competence = findCompetenceById(id);
        Competence.setDeleted(true);
        return putCompetence(Competence, id);
    }

    public Competence addCCompetence(Competence Competence) {
        return CompetenceRepository.save(Competence);
    }

    public Competence findCompetenceById(Long id) {
        return CompetenceRepository.findById(id).get();
    }
}


