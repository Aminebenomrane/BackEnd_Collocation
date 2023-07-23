package com.Collocation.Stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class AnnonceFavori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_ajout")
    private Date dateAjout;
@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;
}
