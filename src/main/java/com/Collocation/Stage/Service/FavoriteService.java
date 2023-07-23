package com.Collocation.Stage.services;

import com.Collocation.Stage.Repository.AnnonceRepository;
import com.Collocation.Stage.Repository.FavoriteRepository;
import com.Collocation.Stage.Repository.UserRepository;
import com.Collocation.Stage.entities.Annonce;
import com.Collocation.Stage.entities.AnnonceFavori;
import com.Collocation.Stage.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final AnnonceRepository annonceRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository, UserRepository userRepository, AnnonceRepository annonceRepository) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.annonceRepository = annonceRepository;
    }

    public List<AnnonceFavori> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    public List<AnnonceFavori> getFavoritesByUser(Integer userId) {
        return favoriteRepository.getFavoritesByUser(userId);
    }

    public AnnonceFavori addFavorite(Integer userId, Integer annonceId) {
        User user = userRepository.findById(userId).orElse(null);
        Annonce annonce = annonceRepository.findById(annonceId).orElse(null);

        if (user != null && annonce != null) {
            AnnonceFavori favorite = new AnnonceFavori();
            favorite.setUser(user);
            favorite.setAnnonce(annonce);
            return favoriteRepository.save(favorite);
        }

        return null;
    }

    public void removeFavorite(Integer favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
}
