package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.LogementService;
import com.Collocation.Stage.entities.Logement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logements")
public class LogementController {

    private final LogementService logementService;

    @Autowired
    public LogementController(LogementService logementService) {
        this.logementService = logementService;
    }

    @GetMapping
    public List<Logement> getAllLogements() {
        return logementService.getAllLogements();
    }

    @GetMapping("/{id}")
    public Logement getLogementById(@PathVariable Integer id) {
        return logementService.getLogementById(id);
    }

    @PostMapping
    public Logement createLogement(@RequestBody Logement logement) {
        return logementService.saveLogement(logement);
    }

    @PutMapping("/{id}")
    public Logement updateLogement(@PathVariable Integer id, @RequestBody Logement updatedLogement) {
        return logementService.updateLogement(id, updatedLogement);
    }

    @DeleteMapping("/{id}")
    public void deleteLogement(@PathVariable Integer id) {
        logementService.deleteLogement(id);
    }
}
