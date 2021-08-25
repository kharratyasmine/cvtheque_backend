package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.models.Candidature_Steps;
import com.cv.theque.cv_theque.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> findAllByDeletedIsFalse() {
        return candidateRepository.findAllWithoutCV() ;
    }

    public String findCvByCandidateId(long id) {
        return candidateRepository.findCvByCandidateId(id) ;
    }

    public Candidate putCandidate(Candidate candidate, Long id) {
        candidate.setCandidate_id(id);
        return candidateRepository.save(candidate);
    }

    public Candidate deleteCandidate(Long id) {
        Candidate candidate = findCandidateById(id);
        candidate.setDeleted(true);
        return putCandidate(candidate, id);
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate findCandidateById(Long id) {
        return candidateRepository.findById(id).get();
    }
    
}
