package com.services.impl;

import com.dtos.CreneauDto;
import com.entities.Creneau;
import com.entities.TypeCreneau;
import com.repositories.CreneauRepository;
import com.services.CreneauService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreneauServiceImpl implements CreneauService {

    private final CreneauRepository creneauRepository;

    public CreneauServiceImpl(CreneauRepository creneauRepository){
                this.creneauRepository = creneauRepository;
    }
    /**
     * Map creneau dto to creneau entity
     * @param creneauDto
     * return creneau
     */
    private Creneau creneauDtoToEntity(CreneauDto creneauDto) {
        Creneau creneau = new Creneau();
        creneau.setDateHeure(creneauDto.getDateHeure());
        creneau.setDuree(creneauDto.getDuree());
        creneau.setType(creneauDto.getType());
        creneau.setId(creneauDto.getId());
        return creneau;
    }

    /**
     * Map creneau entity to creneau dto
     * @param creneau
     * return creneauDto
     */
    private CreneauDto creneauEntityToDto(Creneau creneau) {
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setDateHeure(creneau.getDateHeure());
        creneauDto.setDuree(creneau.getDuree());
        creneauDto.setType(creneau.getType());
        creneauDto.setId(creneau.getId());
        return creneauDto;
    }

    /**
     * Save creneau in database
     * @param creneauDto
     * return creneauDto
     */
    @Override
    public CreneauDto saveCreneau(CreneauDto creneauDto) {
        // Converts the dto to the dog entity
        Creneau creneau = creneauDtoToEntity(creneauDto);
        // Save the dog entity
        creneau = creneauRepository.save(creneau);
        // Return the new dto
        return creneauEntityToDto(creneau);
    }

    /**
     * Get creneau by id
     * @param creneauId
     * return creneauDto
     */
    @Override
    public CreneauDto getCreneauById(Long creneauId) {
        Creneau creneau = creneauRepository.findById(creneauId).orElseThrow(() -> new EntityNotFoundException("Creneau not found"));
        return creneauEntityToDto(creneau);
    }

    /**
     * Delete creneau by id
     * @param creneauId
     * return creneauDto
     */
    @Override
    public boolean deleteCreneau(Long creneauId) {
        creneauRepository.deleteById(creneauId);
        return true;
    }

    /**
     * Get all creneaux
     * return creneauDto
     */
    @Override
    public List<CreneauDto> getAllCreneau() {
        List<CreneauDto> creneauDtos = new ArrayList<>();
        List<Creneau> creneau = creneauRepository.findAll();
        creneau.forEach(creneau1 -> creneauDtos.add(creneauEntityToDto(creneau1)));
        return creneauDtos;
    }
}
