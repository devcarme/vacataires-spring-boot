package com.entities;

import com.repositories.CreneauRepository;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String intitule;

    @OneToMany(mappedBy = "cours")
    private List<Creneau> creneaux;

//    @ManyToMany
//    private Set<FiliereLangue> filiereLangues;
}
