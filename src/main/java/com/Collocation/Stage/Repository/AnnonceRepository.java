package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
}
