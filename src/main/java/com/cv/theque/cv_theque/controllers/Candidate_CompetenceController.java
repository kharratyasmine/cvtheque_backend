package com.cv.theque.cv_theque.controllers;

import com.cv.theque.cv_theque.models.Candidate_Advantage;
import com.cv.theque.cv_theque.models.Candidate_Competence;
import com.cv.theque.cv_theque.services.Candidate_CompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/candidate_competence")
public class Candidate_CompetenceController {
    private final Candidate_CompetenceService Candidate_CompetenceService;

    public Candidate_CompetenceController(Candidate_CompetenceService Candidate_CompetenceService) {
        this.Candidate_CompetenceService = Candidate_CompetenceService;
    }

    @GetMapping()
    public List<Candidate_Competence> findAllCandidate_Competences() {
        return Candidate_CompetenceService.findAllCandidate_Competences();
    }

    @GetMapping("{idCandidature}/{idCandidate}")
    public List<Candidate_Competence> findCompetenceByCandidatureId(@PathVariable Long idCandidature, @PathVariable Long idCandidate) {
        List<Candidate_Competence> candidateCompetences = Candidate_CompetenceService.findCompetenceByCandidatureId(idCandidature, idCandidate);
        candidateCompetences.forEach(candidate_advantage -> candidate_advantage.getCandidate().setCv(""));
        return candidateCompetences;
    }

    @PostMapping()
    public Candidate_Competence addCompetence(@RequestBody Candidate_Competence candidate_competence) {
        return Candidate_CompetenceService.addCandidate_Competence(candidate_competence);
    }

    @PutMapping("{id}")
    public Candidate_Competence putCompetence(@RequestBody Candidate_Competence Candidate_Competence, @PathVariable Long id) {
        return Candidate_CompetenceService.putCandidate_Competence(Candidate_Competence, id);
    }

    @DeleteMapping("{id}")
    public void putCompetence(@PathVariable long id) {
        Candidate_CompetenceService.deleteCandidate_Competence(id);
    }

    @GetMapping("{id}")
    public Candidate_Competence findAllCompetenceById(@PathVariable long id) {
        return Candidate_CompetenceService.findCandidate_CompetenceById(id);
    }
}
