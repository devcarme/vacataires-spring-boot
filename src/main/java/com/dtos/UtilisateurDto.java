package com.dtos;

import lombok.Data;

import javax.persistence.*;

@Data

@MappedSuperclass
public class UtilisateurDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 20)
    private String login;

    @Column(length = 255)
    private String motDePasse;

    @Column(length = 50)
    private String nomUsuel;

    @Column(length = 50)
    private String prenom;

    @Lob
    @Column(name="CONTENT", length=320)
    private String mail;

}
