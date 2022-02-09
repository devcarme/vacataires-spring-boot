package com.dtos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class FiliereLangueDto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String codeFiliereLangue;
    private String nomFiliereLangue;

}
