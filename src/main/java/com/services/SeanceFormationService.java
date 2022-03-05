package com.services;

import com.dtos.SeanceFormationDto;

import java.util.List;


public interface SeanceFormationService {
    /**
     * Enregistre un SeanceFormation
     */
    SeanceFormationDto saveSeanceFormation(SeanceFormationDto seanceFormationDto);

    /**
     * Récupérère un SeanceFormation par son Id
     */
    SeanceFormationDto getSeanceFormationById(Long seanceFormationId);

    /**
     * Supprimer un seanceFormation par son Id
     */
    boolean deleteSeanceFormation(Long seanceFormationId);

    /**
     * Récupérer tous les seanceFormation
     */
    List<SeanceFormationDto> getAllSeanceFormations();


}
