package com.Collocation.Stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Logement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Logement;

    @Column(name = "Pays")
    private String pays;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Prix")
    private String prix;

    @Column(name = "Nombre de Piece")
    private String nb_Piece;

    @Column(name = "Nombre de Personne")
    private String nb_Personne;

    @Column(name = "Surface")
    private String surface;

    @Column(name = "Description")
    private String description;
    @JsonIgnore

    // Relation One-to-One avec Annonce
    @OneToOne(mappedBy = "logement")
    private Annonce annonce;
    // Relation One-to-Many avec Piece
    @JsonIgnore

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logement")
    private List<Piece> pieces = new ArrayList<>();
}
