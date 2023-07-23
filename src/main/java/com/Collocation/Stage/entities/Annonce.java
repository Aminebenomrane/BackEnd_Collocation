package com.Collocation.Stage.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date date_post;
    @JsonIgnore

    @ManyToOne
    private User user;


    // Relation One-to-One avec Logement
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logement_id", referencedColumnName = "id_Logement")
    private Logement logement;


    // Relation One-to-Many avec Image
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annonce")
    private List<Image> images = new ArrayList<>();

    //Favorite
    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<AnnonceFavori> favorites = new ArrayList<>();

}
