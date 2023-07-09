package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.AnnonceRepository;
import com.Collocation.Stage.Service.interfaces.AnnonceInterface;
import com.Collocation.Stage.entities.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService implements AnnonceInterface {

    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public List<Annonce> getAllAnnonce() {
        return annonceRepository.findAll();
    }

    public Annonce getAnnonceById(Integer id) {
        return annonceRepository.findById(id).orElse(null);
    }

    public Annonce saveAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public Annonce updateAnnonce(Integer id, Annonce updatedAnnonce) {
        Annonce annonce = getAnnonceById(id);
        if (annonce != null) {
            // Update annonce fields with the values from updatedAnnonce
            annonce.setTitre(updatedAnnonce.getTitre());
            annonce.setDate_post(updatedAnnonce.getDate_post());

            return annonceRepository.save(annonce);
        }
        return null;
    }

    public void deleteAnnonce(Integer id) {
        annonceRepository.deleteById(id);
    }
}
