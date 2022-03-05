package com.services;

import com.dtos.CreneauDto;

import java.util.List;


public interface CreneauService {
    /**
     * Enregistre un Creneau
     */
    CreneauDto saveCreneau(CreneauDto creneauDto);

    /**
     * Récupérère un Creneau par son Id
     */
    CreneauDto getCreneauById(Long creneauId);

    /**
     * Supprimer un creneau par son Id
     */
    boolean deleteCreneau(Long creneauId);

    /**
     * Récupérer tous les creneau
     */
    List<CreneauDto> getAllCreneau();


}
