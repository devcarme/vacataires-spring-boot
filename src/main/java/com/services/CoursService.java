package com.services;

import com.dtos.CoursDto;

import java.util.List;


public interface CoursService {
    /**
     * Enregistre un Cours
     */
    CoursDto saveCours(CoursDto coursDto);

    /**
     * Récupérère un Cours par son Id
     */
    CoursDto getCoursById(Long coursId);

    /**
     * Supprimer un cours par son Id
     */
    boolean deleteCours(Long coursId);

    /**
     * Récupérer tous les cours
     */
    List<CoursDto> getAllCours();


}
