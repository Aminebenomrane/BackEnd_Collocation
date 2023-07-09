package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.entities.Annonce;

import java.util.List;

public interface AnnonceInterface{
    List<Annonce> getAllAnnonce();

    Annonce getAnnonceById(Integer id);

    Annonce saveAnnonce(Annonce annonce);

    Annonce updateAnnonce(Integer id, Annonce updatedAnnonce);

    void deleteAnnonce(Integer id);
}
