package com.services.impl;

import com.dtos.FiliereLangueDto;
import com.entities.FiliereLangue;
import com.repositories.FiliereLangueRepository;
import com.services.FiliereLangueService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FiliereLangueServiceImpl implements FiliereLangueService {

    private final FiliereLangueRepository filiereLangueRepository;

    public FiliereLangueServiceImpl(FiliereLangueRepository filiereLangueRepository){
                this.filiereLangueRepository = filiereLangueRepository;
    }
    /**
     * Map filiereLangue dto to filiereLangue entity
     * @param filiereLangueDto
     * return FiliereLangue
     */
    private FiliereLangue filiereLangueDtoToEntity(FiliereLangueDto filiereLangueDto) {
        FiliereLangue filiereLangue = new FiliereLangue();
        filiereLangue.setCodeFiliereLangue(filiereLangueDto.getCodeFiliereLangue());
        filiereLangue.setNomFiliereLangue(filiereLangueDto.getNomFiliereLangue());
        filiereLangue.setId(filiereLangueDto.getId());
        return filiereLangue;
    }

    /**
     * Map filiereLangue entity to filiereLangue dto
     * @param filiereLangue
     * return filiereLangueDto
     */
    private FiliereLangueDto filiereLangueEntityToDto(FiliereLangue filiereLangue) {
        FiliereLangueDto filiereLangueDto = new FiliereLangueDto();
        filiereLangueDto.setCodeFiliereLangue(filiereLangue.getCodeFiliereLangue());
        filiereLangueDto.setNomFiliereLangue(filiereLangue.getNomFiliereLangue());
        return filiereLangueDto;
    }

    /**
     * Save filiereLangue in database
     * @param filiereLangueDto
     * @return FiliereLangueDto
     */
    @Override
    public FiliereLangueDto saveFiliereLangue(FiliereLangueDto filiereLangueDto) {
        // Converts the dto to the dog entity
        FiliereLangue filiereLangue = filiereLangueDtoToEntity(filiereLangueDto);
        // Save the dog entity
        filiereLangue = filiereLangueRepository.save(filiereLangue);
        // Return the new dto
        return filiereLangueEntityToDto(filiereLangue);
    }

    /**
     * Get filiereLangue by id
     * @param filiereLangueId
     * @return filiereLangueDto
     */
    @Override
    public FiliereLangueDto getFiliereLangueById(Long filiereLangueId) {
        FiliereLangue filiereLangue = filiereLangueRepository.findById(filiereLangueId).orElseThrow(() -> new EntityNotFoundException("FiliereLangue not found"));
        return filiereLangueEntityToDto(filiereLangue);
    }

    /**
     * Delete filiereLangue by id
     * @param filiereLangueId
     * @return true
     */
    @Override
    public boolean deleteFiliereLangue(Long filiereLangueId) {
        filiereLangueRepository.deleteById(filiereLangueId);
        return true;
    }

    /**
     * Get all filiereLangue
     * @return List<FiliereLangueDto>
     */
    @Override
    public List<FiliereLangueDto> getAllFiliereLangue() {
        List<FiliereLangueDto> filiereLangueDtos = new ArrayList<>();
        List<FiliereLangue> filiereLangue = filiereLangueRepository.findAll();
        filiereLangue.forEach(filiereLangue1 -> filiereLangueDtos.add(filiereLangueEntityToDto(filiereLangue1)));
        return filiereLangueDtos;
    }
}
