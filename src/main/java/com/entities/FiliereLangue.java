package com.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class FiliereLangue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String codeFiliereLangue;
    private String nomFiliereLangue;

    @ManyToOne
    @JoinColumn(name = "composante_id")
    private Composante composante;

    public Composante getComposante() {
        return composante;
    }

    public void setComposante(Composante composante) {
        this.composante = composante;
    }

//    @ManyToMany
//    @JoinTable(name = "filiere_langue",
//            joinColumns = @JoinColumn(name = "filiere_langue_id", referencedColumnName = "cours_id"))
//    private List<Cours> cours = new ArrayList<>();
//
//    public List<Cours> getCours() {
//        return cours;
//    }
//
//    public void setCours(List<Cours> cours) {
//        this.cours = cours;
//    }
}
