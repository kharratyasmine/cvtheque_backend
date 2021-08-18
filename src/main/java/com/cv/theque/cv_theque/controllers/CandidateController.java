package com.cv.theque.cv_theque.controllers;


import com.cv.theque.cv_theque.models.CV;
import com.cv.theque.cv_theque.models.Candidate;
import com.cv.theque.cv_theque.services.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/candidate")
@CrossOrigin("*")
public class CandidateController {

  private final CandidateService candidateService;

  public CandidateController(CandidateService candidateService) {
    this.candidateService = candidateService;
  }

  @GetMapping()
  public List<Candidate> findAllByDeletedIsFalse() {
      List<Candidate> candidateList = candidateService.findAllByDeletedIsFalse();
      candidateList.forEach(candidate -> candidate.setCv(""));
       return candidateList;
    }
  @GetMapping("cv/{id}")
  public CV findCvByCandidateId(@PathVariable Long id) {
      CV currentCv = new CV();
      currentCv.setCv(candidateService.findCvByCandidateId(id));
       return currentCv;
    }

  @GetMapping("/nbrcandidate")
  public long countCandidate() {
       return candidateService.countCandidate();
    }
  @PostMapping()
  public Candidate addCandidate(@RequestBody Candidate candidate) {
       return candidateService.addCandidate(candidate);
    }
  @PutMapping("{id}")
  public Candidate putCandidate(@RequestBody Candidate candidate, @PathVariable Long id) {
       return candidateService.putCandidate(candidate, id);
    }
  @DeleteMapping("{id}")
  public Candidate putCandidate(@PathVariable Long id) {
      return candidateService.deleteCandidate(id);
    }
  @GetMapping("{id}")
  public Candidate findCandidateById(@PathVariable Long id) {
      return candidateService.findCandidateById(id);
    }
}
