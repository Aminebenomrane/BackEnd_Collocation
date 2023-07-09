package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface LogementRepository extends JpaRepository<Logement,Integer> {
}
