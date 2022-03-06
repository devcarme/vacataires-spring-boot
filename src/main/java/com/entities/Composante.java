package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Composante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String nomComposante;

    @OneToMany(mappedBy = "composante")
    private List<FiliereLangue> filiereLangues;

    @OneToMany(mappedBy = "composante")
    private List<Responsable> responsables;

}
