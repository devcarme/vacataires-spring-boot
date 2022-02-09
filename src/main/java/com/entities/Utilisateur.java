package com.entities;

import javax.persistence.*;

import lombok.Data;

@Data

@MappedSuperclass
public class Utilisateur {

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
