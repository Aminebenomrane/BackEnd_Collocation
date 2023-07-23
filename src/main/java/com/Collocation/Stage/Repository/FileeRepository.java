package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.Filee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FileeRepository extends JpaRepository<Filee, Long> {
}
