package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Announcement;
import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.models.Candidature;
import com.cv.theque.cv_theque.repositories.CandidatureRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CandidatureService {

    private final CandidatureRepository candidatureRepository;

    public CandidatureService(CandidatureRepository candidatureRepository) {
        this.candidatureRepository = candidatureRepository;
    }

    public List<Candidature> findAllCandidatures() {
        return candidatureRepository.findAllByDeletedIsFalse();
    }
    public List<Candidature> findCandidatureByCandidate(Long candidate) {
        return candidatureRepository.findCandidature(candidate);
    }
    public long countCandidature() {
        return candidatureRepository.countCandidature() ;
    }

    public Candidature putCandidature(Candidature candidature, Long id) {
        candidature.setId(id);
        return candidatureRepository.save(candidature);
    }
    public Candidature deleteCandidature(Long id) {
        Candidature candidature = findCandidatureById(id);
        candidature.setDeleted(true);
        return putCandidature(candidature, id);
    }

    public Candidature addCandidature(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    public Candidature findCandidatureById(Long id) {
        return candidatureRepository.findById(id).get();
    }
}
