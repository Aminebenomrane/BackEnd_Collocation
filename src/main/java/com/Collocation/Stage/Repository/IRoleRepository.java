package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
