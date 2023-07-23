package com.Collocation.Stage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Filee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFile;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "fileData")
    private byte[] fileData;

    // Ajoutez ici la relation OneToOne avec l'entité User
    @OneToOne(mappedBy = "filee")
    private User user;

    public Filee(String name, String type, byte[] fileData) {
        super();
        this.name=name;
        this.type=type;
        this.fileData=fileData;
    }


}
