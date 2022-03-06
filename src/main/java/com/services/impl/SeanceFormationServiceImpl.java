package com.services.impl;

import com.dtos.SeanceFormationDto;
import com.entities.SeanceFormation;
import com.repositories.SeanceFormationRepository;
import com.services.SeanceFormationService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeanceFormationServiceImpl implements SeanceFormationService {

    private final SeanceFormationRepository seanceFormationRepository;

    public SeanceFormationServiceImpl(SeanceFormationRepository seanceFormationRepository){
                this.seanceFormationRepository = seanceFormationRepository;
    }
    /**
     * Map seanceFormation dto to seanceFormation entity
     */
    private SeanceFormation seanceFormationDtoToEntity(SeanceFormationDto seanceFormationDto) {
        SeanceFormation seanceFormation = new SeanceFormation();
        seanceFormation.setId(seanceFormationDto.getId());
        seanceFormation.setDureeEffective(seanceFormationDto.getDureeEffective());
        seanceFormation.setValide(seanceFormationDto.getValide());
        seanceFormation.setCommentaire(seanceFormationDto.getCommentaire());
        seanceFormation.setEstEffectuee(seanceFormationDto.getEstEffectuee());

        return seanceFormation;
    }

    /**
     * Map seanceFormation entity to seanceFormation dto
     */
    private SeanceFormationDto seanceFormationEntityToDto(SeanceFormation seanceFormation) {
        SeanceFormationDto seanceFormationDto = new SeanceFormationDto();
        seanceFormationDto.setId(seanceFormation.getId());
        seanceFormationDto.setDureeEffective(seanceFormationDto.getDureeEffective());
        seanceFormationDto.setValide(seanceFormationDto.getValide());
        seanceFormationDto.setCommentaire(seanceFormationDto.getCommentaire());
        seanceFormationDto.setEstEffectuee(seanceFormationDto.getEstEffectuee());
        return seanceFormationDto;
    }

    @Override
    public SeanceFormationDto saveSeanceFormation(SeanceFormationDto seanceFormationDto) {
        // Converts the dto to the dog entity
        SeanceFormation seanceFormation = seanceFormationDtoToEntity(seanceFormationDto);
        // Save the dog entity
        seanceFormation = seanceFormationRepository.save(seanceFormation);
        // Return the new dto
        return seanceFormationEntityToDto(seanceFormation);
    }

    @Override
    public SeanceFormationDto getSeanceFormationById(Long seanceFormationId) {
        SeanceFormation seanceFormation = seanceFormationRepository.findById(seanceFormationId).orElseThrow(() -> new EntityNotFoundException("SeanceFormation not found"));
        return seanceFormationEntityToDto(seanceFormation);
    }

    @Override
    public boolean deleteSeanceFormation(Long seanceFormationId) {
        seanceFormationRepository.deleteById(seanceFormationId);
        return true;
    }

    @Override
    public List<SeanceFormationDto> getAllSeanceFormations() {
        List<SeanceFormationDto> seanceFormationDtos = new ArrayList<>();
        List<SeanceFormation> seanceFormation = seanceFormationRepository.findAll();
        seanceFormation.forEach(seanceFormation1 -> seanceFormationDtos.add(seanceFormationEntityToDto(seanceFormation1)));
        return seanceFormationDtos;
    }
}
