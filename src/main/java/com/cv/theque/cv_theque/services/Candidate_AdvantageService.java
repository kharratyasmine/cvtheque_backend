package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Announcement;
import com.cv.theque.cv_theque.models.Candidate_Advantage;
import com.cv.theque.cv_theque.models.Candidate_Competence;
import com.cv.theque.cv_theque.repositories.Candidate_AdvantageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Candidate_AdvantageService {
    private final Candidate_AdvantageRepository Candidate_AdvantageRepository;

    public Candidate_AdvantageService(Candidate_AdvantageRepository Candidate_AdvantageRepository) {
        this.Candidate_AdvantageRepository = Candidate_AdvantageRepository;
    }

    public List<Candidate_Advantage> findAllCandidate_Advantages() {
        return Candidate_AdvantageRepository.findAllByDeletedIsFalse();
    }

    public Candidate_Advantage putCandidate_Advantage(Candidate_Advantage Candidate_Advantage, Long id) {
        Candidate_Advantage.setAdvantage_id(id);
        return Candidate_AdvantageRepository.save(Candidate_Advantage);
    }

    public Candidate_Advantage deleteCandidate_Advantage(Long id) {
        Candidate_Advantage Candidate_Advantage = findCandidate_AdvantageById(id);
        Candidate_Advantage.setDeleted(true);
        return putCandidate_Advantage(Candidate_Advantage, id);
    }
    public List<Candidate_Advantage> findAdvantageByCandidatureId(Long idCandidature, Long idCandidate) {
        return Candidate_AdvantageRepository.findAdvantageByCandidatureId(idCandidature, idCandidate);
    }

    public Candidate_Advantage addCandidate_Advantage(Candidate_Advantage Candidate_Advantage) {
        return Candidate_AdvantageRepository.save(Candidate_Advantage);
    }

    public Candidate_Advantage findCandidate_AdvantageById(long id) {
        return Candidate_AdvantageRepository.findById(id).get();
    }

}
