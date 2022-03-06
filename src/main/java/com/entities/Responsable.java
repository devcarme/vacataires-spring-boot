package com.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data

public class Responsable extends Utilisateur{

    @ManyToOne
    @JoinColumn(name = "composante_id")
    private Composante composante;

    public Composante getComposante() {
        return composante;
    }

    public void setComposante(Composante composante) {
        this.composante = composante;
    }
}
