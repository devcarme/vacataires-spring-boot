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
     * @param seanceFormationDto
     * @return SeanceFormation entity
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
     * @param seanceFormation
     * @return SeanceFormationDto
     */
    private SeanceFormationDto seanceFormationEntityToDto(SeanceFormation seanceFormation) {
        SeanceFormationDto seanceFormationDto = new SeanceFormationDto();
        seanceFormationDto.setId(seanceFormation.getId());
        seanceFormationDto.setDureeEffective(seanceFormation.getDureeEffective());
        seanceFormationDto.setValide(seanceFormation.getValide());
        seanceFormationDto.setCommentaire(seanceFormation.getCommentaire());
        seanceFormationDto.setEstEffectuee(seanceFormation.getEstEffectuee());
        return seanceFormationDto;
    }

    /**
     * Save seanceFormation in database
     * @param seanceFormationDto
     * @return SeanceFormationDto
     */
    @Override
    public SeanceFormationDto saveSeanceFormation(SeanceFormationDto seanceFormationDto) {
        // Converts the dto to the dog entity
        SeanceFormation seanceFormation = seanceFormationDtoToEntity(seanceFormationDto);
        // Save the dog entity
        seanceFormation = seanceFormationRepository.save(seanceFormation);
        // Return the new dto
        return seanceFormationEntityToDto(seanceFormation);
    }

    /**
     * Get seanceFormation by id
     * @param seanceFormationId
     * @return SeanceFormationDto
     */
    @Override
    public SeanceFormationDto getSeanceFormationById(Long seanceFormationId) {
        SeanceFormation seanceFormation = seanceFormationRepository.findById(seanceFormationId).orElseThrow(() -> new EntityNotFoundException("SeanceFormation not found"));
        return seanceFormationEntityToDto(seanceFormation);
    }

    /**
     * Delete seanceFormation by id
     * @param seanceFormationId
     * @return true
     */
    @Override
    public boolean deleteSeanceFormation(Long seanceFormationId) {
        seanceFormationRepository.deleteById(seanceFormationId);
        return true;
    }

    /**
     * Get all seanceFormation
     * @return List<SeanceFormationDto>
     */
    @Override
    public List<SeanceFormationDto> getAllSeanceFormations() {
        List<SeanceFormationDto> seanceFormationDtos = new ArrayList<>();
        List<SeanceFormation> seanceFormation = seanceFormationRepository.findAll();
        seanceFormation.forEach(seanceFormation1 -> seanceFormationDtos.add(seanceFormationEntityToDto(seanceFormation1)));
        return seanceFormationDtos;
    }
}
