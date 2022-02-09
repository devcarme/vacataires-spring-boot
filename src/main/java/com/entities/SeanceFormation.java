package com.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SeanceFormation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private Integer dureeEffective;
    private Boolean valide;

    @Lob
    @Column(name="CONTENT", length=512)
    private String commentaire;

}
