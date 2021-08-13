package com.cv.theque.cv_theque.controllers;

import com.cv.theque.cv_theque.models.Competence;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping("api/competence")
@CrossOrigin("*")
public class CompetenceController {
    private final com.cv.theque.cv_theque.services.CompetenceService CompetenceService;

    public CompetenceController(com.cv.theque.cv_theque.services.CompetenceService CompetenceService) {
        this.CompetenceService = CompetenceService;
    }

    @GetMapping()
    public List<Competence> findAllCompetences() {
        return CompetenceService.findAllCompetences();
    }
    @PostMapping()
    public Competence addCompetence(@RequestBody Competence Competence) {
        return CompetenceService.addCCompetence(Competence);
    }
    @PutMapping("{id}")
    public Competence putCompetence(@RequestBody Competence Competence, @PathVariable Long id) {
        return CompetenceService.putCompetence(Competence, id);
    }
    @DeleteMapping("{id}")
    public Competence putCompetence(@PathVariable Long id) {
        return CompetenceService.deleteCompetence(id);
    }
    @GetMapping("{id}")
    public Competence findCompetenceById(@PathVariable Long id) {
        return CompetenceService.findCompetenceById(id);
    }
}


