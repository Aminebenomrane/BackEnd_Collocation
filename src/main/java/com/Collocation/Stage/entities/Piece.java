package com.Collocation.Stage.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Piece;

    @Column(name = "Surface")
    private double surface;

    @Column(name = "Prix")
    private double prix;

    @Column(name = "Disponibilite")
    private Boolean disponibilite;

    @Column(name = "Nombre de lit")
    private int nb_lit;

    @Column(name = "Date de debut")
    private Date date_Debut;

    @Column(name = "Date de fin")
    private Date date_fin;

    // Relation Many-to-One avec Logement
    @ManyToOne
    @JoinColumn(name = "logement_id")
    private Logement logement;
}
