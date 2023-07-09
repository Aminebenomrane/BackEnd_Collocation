package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PieceRepository extends JpaRepository<Piece,Integer> {

}
