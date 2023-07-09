package com.Collocation.Stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_annonce;

    @Column(name = "Titre")
    private String titre;

    @Column(name = "Date")
    private Date date_post;
    @JsonIgnore

    @ManyToMany(mappedBy = "annonces")
    private List<User> users;
    // Relation One-to-One avec Logement
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logement_id", referencedColumnName = "id_Logement")
    private Logement logement;
    // Relation One-to-Many avec Image
    @JsonIgnore

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annonce")
    private List<Image> images = new ArrayList<>();
}
