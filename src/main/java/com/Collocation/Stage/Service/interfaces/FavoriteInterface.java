package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.entities.AnnonceFavori;

import java.util.List;

public interface FavoriteInterface {
    List<AnnonceFavori> getAllFavorites();
    List<AnnonceFavori> getFavoritesByUser(Integer userId);
    AnnonceFavori addFavorite(Integer userId, Integer annonceId);
    void removeFavorite(Integer favoriteId);
}
