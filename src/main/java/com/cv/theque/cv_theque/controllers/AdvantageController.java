package com.cv.theque.cv_theque.controllers;

import com.cv.theque.cv_theque.models.Advantage;
import com.cv.theque.cv_theque.services.AdvantageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/advantage")
@CrossOrigin("*")
public class AdvantageController {
    private final AdvantageService AdvantageService;

    public AdvantageController(AdvantageService AdvantageService) {
        this.AdvantageService = AdvantageService;
    }

    @GetMapping()
    public List<Advantage> findAllAdvantages() {
        return AdvantageService.findAllAdvantages();
    }

    @PostMapping()
    public Advantage addAdvantage(@RequestBody Advantage advantage) {
        return AdvantageService.addAdvantage(advantage);
    }

    @PutMapping("{id}")
    public Advantage putAdvantage(@RequestBody Advantage advantage, @PathVariable Long id) {
        return AdvantageService.putAdvantage(advantage, id);
    }

    @DeleteMapping("{id}")
    public Advantage deleteAdvantage(@PathVariable Long id) {
       return AdvantageService.deleteAdvantage(id);
    }

    @GetMapping("{id}")
    public Advantage findAdvantageById(@PathVariable Long id) {
        return AdvantageService.findAdvantageById(id);
    }
}

