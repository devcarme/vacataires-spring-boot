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
     */
    private CreneauDto creneauEntityToDto(Creneau creneau) {
        CreneauDto creneauDto = new CreneauDto();
        creneauDto.setDateHeure(creneauDto.getDateHeure());
        creneauDto.setDuree(creneauDto.getDuree());
        creneauDto.setType(creneauDto.getType());
        creneauDto.setId(creneauDto.getId());
        return creneauDto;
    }

    @Override
    public CreneauDto saveCreneau(CreneauDto creneauDto) {
        // Converts the dto to the dog entity
        Creneau creneau = creneauDtoToEntity(creneauDto);
        // Save the dog entity
        creneau = creneauRepository.save(creneau);
        // Return the new dto
        return creneauEntityToDto(creneau);
    }

    @Override
    public CreneauDto getCreneauById(Long creneauId) {
        Creneau creneau = creneauRepository.findById(creneauId).orElseThrow(() -> new EntityNotFoundException("Creneau not found"));
        return creneauEntityToDto(creneau);
    }

    @Override
    public boolean deleteCreneau(Long creneauId) {
        creneauRepository.deleteById(creneauId);
        return true;
    }

    @Override
    public List<CreneauDto> getAllCreneau() {
        List<CreneauDto> creneauDtos = new ArrayList<>();
        List<Creneau> creneau = creneauRepository.findAll();
        creneau.forEach(creneau1 -> creneauDtos.add(creneauEntityToDto(creneau1)));
        return creneauDtos;
    }
}
