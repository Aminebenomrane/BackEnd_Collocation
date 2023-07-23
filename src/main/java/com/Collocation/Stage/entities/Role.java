package com.Collocation.Stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@Enumerated(EnumType.STRING)
    private RoleName nomRole;

    @JsonIgnore

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<User> users =  new HashSet<>();


}
