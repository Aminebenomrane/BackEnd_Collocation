package com.Collocation.Stage.Repository;

import com.Collocation.Stage.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource


public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.nom LIKE :letter%")
    List<User> findByUsernameStartingWithLetter(@Param("letter") String letter);
    @Query("SELECT u FROM User u JOIN u.hobbies h WHERE h.nom_Hobby = :hobby")
    List<User> findUsersWithCommonHobby(@Param("hobby") String hobby);
}