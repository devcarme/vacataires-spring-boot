package com.services;

import com.dtos.FiliereLangueDto;

import java.util.List;


public interface FiliereLangueService {
    /**
     * Enregistre un FiliereLangue
     */
    FiliereLangueDto saveFiliereLangue(FiliereLangueDto filiereLangueDto);

    /**
     * Récupérère un FiliereLangue par son Id
     */
    FiliereLangueDto getFiliereLangueById(Long filiereLangueId);

    /**
     * Supprimer un filiereLangue par son Id
     */
    boolean deleteFiliereLangue(Long filiereLangueId);

    /**
     * Récupérer tous les filiereLangue
     */
    List<FiliereLangueDto> getAllFiliereLangue();


}
