package com.cv.theque.cv_theque.services;

import com.cv.theque.cv_theque.models.Advantage;
import com.cv.theque.cv_theque.models.Competence;
import com.cv.theque.cv_theque.repositories.AdvantageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdvantageService {
    private final AdvantageRepository AdvantageRepository;

    public AdvantageService(AdvantageRepository AdvantageRepository) {
        this.AdvantageRepository = AdvantageRepository;
    }

    public List<Advantage> findAllAdvantages() {
        return AdvantageRepository.findAllByDeletedIsFalse();
    }

    public Advantage putAdvantage(Advantage advantage, Long id) {
        advantage.setId_advantage(id);
        return AdvantageRepository.save(advantage);
    }

    public Advantage deleteAdvantage(Long id) {
        Advantage advantage = findAdvantageById(id);
        advantage.setDeleted(true);
        return putAdvantage(advantage, id);
    }

    public Advantage addAdvantage(Advantage advantage) {
        return AdvantageRepository.save(advantage);
    }

    public Advantage findAdvantageById(Long id) {
        return AdvantageRepository.findById(id).get();
    }
}

