package com.cv.theque.cv_theque.controllers;
import com.cv.theque.cv_theque.models.Diploma;
import com.cv.theque.cv_theque.services.DiplomaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/diploma")
@CrossOrigin("*")
public class DiplomaController {
  private final DiplomaService DiplomaService;

  public DiplomaController(DiplomaService DiplomaService) {
    this.DiplomaService = DiplomaService;
  }

  @GetMapping()
  public List<Diploma> findAllDiplomas() {
       return DiplomaService.findAllDiplomas();
    }
  @PostMapping()
  public Diploma addDiploma(@RequestBody Diploma Diploma) {
       return DiplomaService.addDiploma(Diploma);
    }
  @PutMapping("{id}")
  public Diploma putDiploma(@RequestBody Diploma Diploma, @PathVariable Long id) {
       return DiplomaService.putDiploma(Diploma, id);
    }
  @DeleteMapping("{id}")
  public Diploma putDiploma(@PathVariable Long id) {
      return DiplomaService.deleteDiploma(id);
    }
  @GetMapping("{id}")
  public Diploma findDiplomaById(@PathVariable Long id) {
      return DiplomaService.findDiplomaById(id);
    }
}
