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
    private final JavaMailSender emailSender;
    public Candidature_StepsController(Candidature_StepsService candidature_StepsService, JavaMailSender emailSender) {
        this.candidature_StepsService = candidature_StepsService;
        this.emailSender = emailSender;
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
    public long countCandidaturebyrh() {
        return candidature_StepsService.countCandidaturebyrh();
    }
    @GetMapping("/nbrcandidaturebyTechnique")
    public long countCandidaturebyTechnique() {
        return candidature_StepsService.countCandidaturebyTechnique();
    }
    @GetMapping("/nbrcandidaturebyorale")
    public long countCandidaturebyorale() {
        return candidature_StepsService.countCandidaturebyorale();
    }
    @GetMapping("/nbrcandidaturebyautre")
    public long countCandidaturebyautre() {
        return candidature_StepsService.countCandidaturebyautre();
    }

    @GetMapping("query/{idCandidature}/{idCandidate}")
    public Collection<Candidature_Steps> findAllCandidature_Candidate(@PathVariable Long idCandidature, @PathVariable Long idCandidate) {
        return candidature_StepsService.findAllCandidature_Candidate(idCandidature, idCandidate);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Candidature_Steps addCandidature_Steps(@RequestBody Candidature_Steps Candidature_Steps) {
        // Create a Simple MailMessage.
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setTo("bouchaala.omayma@gmail.com");
//        message.setSubject("test");
//        message.setText("testing send ");
//
//        // Send Message!
//        this.emailSender.send(message);
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
