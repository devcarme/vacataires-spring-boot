package com.services;

import com.dtos.VacataireDto;

import java.util.List;


public interface VacataireService {
    /**
     * Enregistre un Vacataire
     */
    VacataireDto saveVacataire(VacataireDto VacataireDto);

    /**
     * Récupérère un Vacataire par son Id
     */
    VacataireDto getVacataireById(Long VacataireId);

    /**
     * Supprimer un Vacataire par son Id
     */
    boolean deleteVacataire(Long VacataireId);

    /**
     * Récupérer tous les vacataire
     */
    List<VacataireDto> getAllVacataires();


}
