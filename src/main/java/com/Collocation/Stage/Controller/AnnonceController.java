package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.AnnonceService;
import com.Collocation.Stage.entities.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    private final AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping()
    public List<Annonce> getAllAnnonce() {
        return annonceService.getAllAnnonce();
    }

    @GetMapping("/{id}")
    public Annonce getAnnonceById(@PathVariable Integer id) {
        return annonceService.getAnnonceById(id);
    }

    @PostMapping
    public Annonce createAnnonce(@RequestBody Annonce annonce) {
        return annonceService.saveAnnonce(annonce);
    }

    @PutMapping("/{id}")
    public Annonce updateAnnonce(@PathVariable Integer id, @RequestBody Annonce updatedAnnonce) {
        return annonceService.updateAnnonce(id, updatedAnnonce);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable Integer id) {
        annonceService.deleteAnnonce(id);
    }
}
