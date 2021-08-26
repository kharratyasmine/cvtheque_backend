package com.cv.theque.cv_theque.services;
import com.cv.theque.cv_theque.models.Candidature_Steps;
import com.cv.theque.cv_theque.repositories.Candidature_StepsRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
public class Candidature_StepsService {
    private static Candidature_StepsRepository Candidature_StepsRepository;

    public Candidature_StepsService(Candidature_StepsRepository Candidature_StepsRepository) {
        this.Candidature_StepsRepository = Candidature_StepsRepository;
    }

    public  List<Candidature_Steps> countCandidaturebyrh() {
        return Candidature_StepsRepository.countCandidaturebyrh();
    }

    public List<Candidature_Steps> countCandidaturebyTechnique() {
        return Candidature_StepsRepository.countCandidaturebyTechnique();
    }

    public  List<Candidature_Steps> countCandidaturebyorale() {
        return Candidature_StepsRepository.countCandidaturebyorale();
    }

    public  List<Candidature_Steps>  countCandidaturebyautre() {
        return Candidature_StepsRepository.countCandidaturebyautre();
    }

    public List<Candidature_Steps> findAllCandidatures_Steps() {
        return Candidature_StepsRepository.findAll();
    }

    public List<Candidature_Steps> findAllByRh() {
        return Candidature_StepsRepository.findAllByRh();
    }

    public static Candidature_Steps putCandidature_Steps(Candidature_Steps Candidature_Steps, Long id) {
        Candidature_Steps.setId_candidature_steps(id);
        return Candidature_StepsRepository.save(Candidature_Steps);
    }

    public Candidature_Steps deleteCandidature_Steps(Long id) {
        Candidature_Steps candidature_steps = findCandidature_StepsById(id);
        candidature_steps.setDeleted(true);
        return putCandidature_Steps(candidature_steps, id);
    }

    public Candidature_Steps addCandidature_Steps(Candidature_Steps Candidature_Steps) {
        return Candidature_StepsRepository.save(Candidature_Steps);
    }

    public Candidature_Steps findCandidature_StepsById(Long id) {
        return Candidature_StepsRepository.findById(id).get();
    }

    public Collection<Candidature_Steps> findAllCandidature_Candidate(Long idCandidature,Long idCandidate) {
        return Candidature_StepsRepository.findAllCandidature_Candidate(idCandidature, idCandidate);
    }
}
