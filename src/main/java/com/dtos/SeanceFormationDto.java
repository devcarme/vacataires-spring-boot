package com.dtos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SeanceFormationDto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private Integer dureeEffective;
    private Boolean valide;
    private Boolean estEffectuee;

    @Lob
    @Column(name="CONTENT", length=512)
    private String commentaire;

}
