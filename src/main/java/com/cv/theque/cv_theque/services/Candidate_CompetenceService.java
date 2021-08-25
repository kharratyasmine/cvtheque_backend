package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Announcement;
import com.cv.theque.cv_theque.models.Candidate_Competence;
import com.cv.theque.cv_theque.repositories.Candidate_CompetenceRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Candidate_CompetenceService {
    private final Candidate_CompetenceRepository candidate_CompetenceRepository;

    public Candidate_CompetenceService(Candidate_CompetenceRepository candidate_CompetenceRepository) {
        this.candidate_CompetenceRepository = candidate_CompetenceRepository;
    }

    public List<Candidate_Competence> findAllCandidate_Competences() {
        return candidate_CompetenceRepository.findAllByDeletedIsFalse();
    }

    public List<Candidate_Competence> findCompetenceByCandidatureId(Long idCandidature, Long idCandidate) {
        return candidate_CompetenceRepository.findCompetenceByCandidatureId(idCandidature, idCandidate);
    }

    public Candidate_Competence putCandidate_Competence(Candidate_Competence candidate_Competence, Long id) {
        candidate_Competence.setId_candidate_competence(id);
        return candidate_CompetenceRepository.save(candidate_Competence);
    }

    public void deleteCandidate_Competence(Long id) {
        candidate_CompetenceRepository.deleteById(id);
    }
    public Candidate_Competence addCandidate_Competence(Candidate_Competence candidateCompetence) {
        return candidate_CompetenceRepository.save(candidateCompetence);
    }

    public Candidate_Competence findCandidate_CompetenceById(long id) {
        return candidate_CompetenceRepository.findById(id).get();
    }

}
