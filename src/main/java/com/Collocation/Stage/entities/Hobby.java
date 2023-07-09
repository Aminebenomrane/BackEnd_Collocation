package com.Collocation.Stage.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_Hobby;
    @Column(name = "nom")
    private String nom_Hobby;
    @Column(name = "Description")
    private String description;

    @ManyToMany(mappedBy = "hobbies")
    private List<User> users;

}
