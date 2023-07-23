package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.Logement;
import com.Collocation.Stage.entities.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PieceRepository extends JpaRepository<Piece, Integer> {
    @Query("SELECT p FROM Piece p WHERE p.disponibilite = true")
    List<Piece> findAvailablePieces();
}



