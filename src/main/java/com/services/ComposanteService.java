package com.services;

import com.dtos.ComposanteDto;

import java.util.List;


public interface ComposanteService {
    /**
     * Enregistre un Composante
     */
    ComposanteDto saveComposante(ComposanteDto composanteDto);

    /**
     * Récupérère un Composante par son Id
     */
    ComposanteDto getComposanteById(Long composanteId);

    /**
     * Supprimer un composante par son Id
     */
    boolean deleteComposante(Long composanteId);

    /**
     * Récupérer tous les composante
     */
    List<ComposanteDto> getAllComposante();


}
