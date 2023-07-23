package com.Collocation.Stage.Controller;

import com.Collocation.Stage.entities.AnnonceFavori;
import com.Collocation.Stage.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public List<AnnonceFavori> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }

    @GetMapping("/user/{userId}")
    public List<AnnonceFavori> getFavoritesByUser(@PathVariable Integer userId) {
        return favoriteService.getFavoritesByUser(userId);
    }

    @PostMapping("/user/{userId}/annonce/{annonceId}")
    public AnnonceFavori addFavorite(@PathVariable Integer userId, @PathVariable Integer annonceId) {
        return favoriteService.addFavorite(userId, annonceId);
    }

    @DeleteMapping("/{favoriteId}")
    public void removeFavorite(@PathVariable Integer favoriteId) {
        favoriteService.removeFavorite(favoriteId);
    }
}
