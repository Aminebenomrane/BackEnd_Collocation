package com.Collocation.Stage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_Image;
    @Column(name = "Image_URL")
    private String image_URL;

    @Column(name = "Description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;

}
