package com.Collocation.Stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "e_mail")
    private String eMail;

    @Column(name = "password")
    private String password;
    @Column(name = "Confirme Password")
    private String Confirme_Password;

    @Column(name = "Age")
    private String age;

    @Column(name = "Profession")
    private String profession;

    @Column(name = "ImageURL")
    private String imageURL;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_hobby",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id")
    )
    private List<Hobby> hobbies;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Annonce> annonces = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AnnonceFavori> favorites = new ArrayList<>();

    @OneToOne
    private Filee filee;
}


