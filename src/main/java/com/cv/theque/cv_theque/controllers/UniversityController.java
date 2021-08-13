package com.cv.theque.cv_theque.controllers;
import com.cv.theque.cv_theque.models.University;
import com.cv.theque.cv_theque.services.UniversityService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("api/university")
@CrossOrigin("*")
public class UniversityController {
  private final UniversityService UniversityService;

  public UniversityController(UniversityService UniversityService) {
    this.UniversityService = UniversityService;
  }

  @GetMapping()
  public List<University> findAllUniversities() {
       return UniversityService.findAllUniversities();
    }
  @PostMapping()
  public University addUniversity(@RequestBody University University) {
       return UniversityService.addUniversity(University);
    }
  @PutMapping("{id}")
  public University putUniversity(@RequestBody University University, @PathVariable Long id) {
       return UniversityService.putUniversity(University, id);
    }
  @DeleteMapping("{id}")
  public University putUniversity(@PathVariable Long id) {
      return UniversityService.deleteUniversity(id);
    }
  @GetMapping("{id}")
  public University findUniversityById(@PathVariable Long id) {
      return UniversityService.findUniversityById(id);
    }
}
