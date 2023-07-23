package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.AnnonceService;
import com.Collocation.Stage.entities.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "/addpost/{user_id}")
    public Annonce addAnnonce(@RequestBody Annonce annonce,@PathVariable int user_id  ){
        return annonceService.addAnnonce(annonce,user_id);}
    @GetMapping("/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable int id) {
        Annonce annonce = annonceService.getAnnonceById(id);
        if (annonce == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(annonce);
    }



}
