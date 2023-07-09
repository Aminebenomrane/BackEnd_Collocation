package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.Hobby;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface HobbyRepository extends JpaRepository<Hobby,Integer> {
}
