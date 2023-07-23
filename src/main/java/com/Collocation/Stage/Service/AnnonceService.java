package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.AnnonceRepository;
import com.Collocation.Stage.Repository.UserRepository;
import com.Collocation.Stage.Service.interfaces.AnnonceInterface;
import com.Collocation.Stage.entities.Annonce;
import com.Collocation.Stage.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class AnnonceService implements AnnonceInterface {

    private final AnnonceRepository annonceRepository;
    private final UserRepository userRepository;


    @Autowired
    public AnnonceService(UserRepository userRepository, AnnonceRepository annonceRepository) {
        this.userRepository = userRepository;
        this.annonceRepository = annonceRepository;
    }

    @Override
    public Annonce addAnnonce(Annonce annonce, int user_id) {
        User user = userRepository.findById(user_id).get();
       annonce.setUser(user);
       return annonceRepository.save(annonce);

    }
    public Annonce getAnnonceById(int id) {
        return annonceRepository.findById(id).orElse(null);
    }
}
