package com.cv.theque.cv_theque.controllers;

import com.cv.theque.cv_theque.models.Candidature_Steps;;
import com.cv.theque.cv_theque.services.Candidature_StepsService;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController()
@RequestMapping("api/candidature_steps")
@CrossOrigin("*")
public class Candidature_StepsController {
    private final Candidature_StepsService candidature_StepsService;
    public Candidature_StepsController(Candidature_StepsService candidature_StepsService) {
        this.candidature_StepsService = candidature_StepsService;
    }

    @GetMapping()
    public List<Candidature_Steps> findAllCandidatures_Steps() {
        return candidature_StepsService.findAllCandidatures_Steps();
    }

    @GetMapping("/listcandidaturebyrh")
    public List<Candidature_Steps> findAllByRh() {
        return candidature_StepsService.findAllByRh();
    }

    @GetMapping("/nbrcandidaturebyrh")
    public  List<Candidature_Steps> countCandidaturebyrh() {
        List<Candidature_Steps> candidature_steps = candidature_StepsService.countCandidaturebyrh();
        candidature_steps.forEach(candidature_step -> candidature_step.getCandidature().getCandidate().setCv("") );
        return candidature_steps;
    }

    @GetMapping("/nbrcandidaturebyTechnique")
    public List<Candidature_Steps> countCandidaturebyTechnique() {
        List<Candidature_Steps> candidature_steps = candidature_StepsService.countCandidaturebyTechnique();
        candidature_steps.forEach(candidature_step -> candidature_step.getCandidature().getCandidate().setCv("") );
        return candidature_steps;
    }

    @GetMapping("/nbrcandidaturebyorale")
    public  List<Candidature_Steps> countCandidaturebyorale() {
        List<Candidature_Steps> candidature_steps = candidature_StepsService.countCandidaturebyorale();
        candidature_steps.forEach(candidature_step -> candidature_step.getCandidature().getCandidate().setCv("") );
        return candidature_steps;
    }

    @GetMapping("/nbrcandidaturebyautre")
    public  List<Candidature_Steps>  countCandidaturebyautre() {
        List<Candidature_Steps> candidature_steps = candidature_StepsService.countCandidaturebyautre();
        candidature_steps.forEach(candidature_step -> candidature_step.getCandidature().getCandidate().setCv("") );
        return candidature_steps;
    }

    @GetMapping("query/{idCandidature}/{idCandidate}")
    public Collection<Candidature_Steps> findAllCandidature_Candidate(@PathVariable Long idCandidature, @PathVariable Long idCandidate) {
        return candidature_StepsService.findAllCandidature_Candidate(idCandidature, idCandidate);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Candidature_Steps addCandidature_Steps(@RequestBody Candidature_Steps Candidature_Steps) {
        return candidature_StepsService.addCandidature_Steps(Candidature_Steps);
    }

    @PutMapping("{id}")
    public Candidature_Steps putCandidature_Steps(@RequestBody Candidature_Steps candidature_steps, @PathVariable Long id) {
        return Candidature_StepsService.putCandidature_Steps(candidature_steps, id);
    }

    @DeleteMapping("{id}")
    public Candidature_Steps putCandidature_Steps(@PathVariable Long id) { return candidature_StepsService.deleteCandidature_Steps(id);
    }

    @GetMapping("{id}")
    public Candidature_Steps findCandidate_StepsById(@PathVariable Long id) {
        return candidature_StepsService.findCandidature_StepsById(id);
    }

}
