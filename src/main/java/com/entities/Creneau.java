package com.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Creneau {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateHeure;
    private Integer duree;

//    @Enumerated(EnumType.ORDINAL)
//    private TypeCreneau type;
    private String type;

    @OneToMany(mappedBy = "creneau")
    private List<SeanceFormation> seancesFormations;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
