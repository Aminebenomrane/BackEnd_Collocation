package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.AnnonceFavori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FavoriteRepository extends JpaRepository<AnnonceFavori,Integer> {
    @Query("SELECT f FROM AnnonceFavori f WHERE f.user.id_user = :userId")
    List<AnnonceFavori> getFavoritesByUser(@Param("userId") Integer userId);

}
