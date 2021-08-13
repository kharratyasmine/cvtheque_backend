package com.cv.theque.cv_theque.controllers;


import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.models.Candidature;
import com.cv.theque.cv_theque.services.CandidatureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/candidature")
@CrossOrigin("*")
public class CandidatureController {
    private final CandidatureService candidatureService;

    public CandidatureController(CandidatureService candidatureService) {
        this.candidatureService = candidatureService;
    }

    @GetMapping()
    public List<Candidature> findAllCandidatures() {
        return candidatureService.findAllCandidatures();
    }
    @GetMapping("candidate/{id}")
    public Candidature findCandidature(@PathVariable Long id) {
        return candidatureService.findCandidatureByCandidate(id);
    }
    @PostMapping()
    public Candidature addCandidature(@RequestBody Candidature candidature) {
        return candidatureService.addCandidature(candidature);
    }
    @PutMapping("{id}")
    public Candidature putCandidature(@RequestBody Candidature candidature, @PathVariable Long id) {
        return candidatureService.putCandidature(candidature, id);
    }
    @DeleteMapping("{id}")
    public void putCandidature(@PathVariable Long id) {
        candidatureService.deleteCandidature(id);
    }
    @GetMapping("{id}")
    public Candidature findCandidateById(@PathVariable Long id) {
        return candidatureService.findCandidatureById(id);
    }
}