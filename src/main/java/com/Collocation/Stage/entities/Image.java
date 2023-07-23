package com.Collocation.Stage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_Image;
    @Column(name = "Nom_Image")
    private String nom_Image;

    @Column(name = "Type_Image")
    private String type_Image;
    @Column(name = "Taille_Image" , length = 420000)
    private Byte taille_Image;
    @ManyToOne
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
