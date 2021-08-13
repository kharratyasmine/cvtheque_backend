package com.cv.theque.cv_theque.controllers;

import com.cv.theque.cv_theque.models.Candidate_Advantage;
import com.cv.theque.cv_theque.models.Candidate_Competence;
import com.cv.theque.cv_theque.services.Candidate_AdvantageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/candidate_advantages")
@CrossOrigin("*")
public class Candidate_AdvantageController {
    private final Candidate_AdvantageService Candidate_AdvantageService;

    public Candidate_AdvantageController(Candidate_AdvantageService Candidate_AdvantageService) {
        this.Candidate_AdvantageService= Candidate_AdvantageService;
    }

    @GetMapping()
    public List<Candidate_Advantage> findAllCandidate_Advantage() {
        return Candidate_AdvantageService.findAllCandidate_Advantages();
    }

    @GetMapping("{idCandidature}/{idCandidate}")
    public List<Candidate_Advantage> findAdvantageByCandidatureId(@PathVariable Long idCandidature, @PathVariable Long idCandidate) {
        return Candidate_AdvantageService.findAdvantageByCandidatureId(idCandidature, idCandidate);
    }
    @PostMapping()
    public Candidate_Advantage addCandidate_Advantage (@RequestBody Candidate_Advantage Candidate_Advantage) {
        return Candidate_AdvantageService.addCandidate_Advantage(Candidate_Advantage);
    }
    @PutMapping("{id}")
    public Candidate_Advantage putCandidate_Advantage (@RequestBody Candidate_Advantage Candidate_Advantage, @PathVariable Long id) {
        return Candidate_AdvantageService.putCandidate_Advantage(Candidate_Advantage, id);
    }
    @DeleteMapping("{id}")
    public void putCandidate_Advantage (@PathVariable long id) {
        Candidate_AdvantageService.deleteCandidate_Advantage(id);
    }
    @GetMapping("{id}")
    public Candidate_Advantage findAllCandidate_AdvantageById(@PathVariable long id) {
        return Candidate_AdvantageService.findCandidate_AdvantageById(id);
    }
}
