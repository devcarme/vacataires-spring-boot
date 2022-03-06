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
     */
    private FiliereLangueDto filiereLangueEntityToDto(FiliereLangue filiereLangue) {
        FiliereLangueDto filiereLangueDto = new FiliereLangueDto();
        filiereLangueDto.setCodeFiliereLangue(filiereLangueDto.getCodeFiliereLangue());
        filiereLangueDto.setNomFiliereLangue(filiereLangueDto.getNomFiliereLangue());
        return filiereLangueDto;
    }

    @Override
    public FiliereLangueDto saveFiliereLangue(FiliereLangueDto filiereLangueDto) {
        // Converts the dto to the dog entity
        FiliereLangue filiereLangue = filiereLangueDtoToEntity(filiereLangueDto);
        // Save the dog entity
        filiereLangue = filiereLangueRepository.save(filiereLangue);
        // Return the new dto
        return filiereLangueEntityToDto(filiereLangue);
    }

    @Override
    public FiliereLangueDto getFiliereLangueById(Long filiereLangueId) {
        FiliereLangue filiereLangue = filiereLangueRepository.findById(filiereLangueId).orElseThrow(() -> new EntityNotFoundException("FiliereLangue not found"));
        return filiereLangueEntityToDto(filiereLangue);
    }

    @Override
    public boolean deleteFiliereLangue(Long filiereLangueId) {
        filiereLangueRepository.deleteById(filiereLangueId);
        return true;
    }

    @Override
    public List<FiliereLangueDto> getAllFiliereLangue() {
        List<FiliereLangueDto> filiereLangueDtos = new ArrayList<>();
        List<FiliereLangue> filiereLangue = filiereLangueRepository.findAll();
        filiereLangue.forEach(filiereLangue1 -> filiereLangueDtos.add(filiereLangueEntityToDto(filiereLangue1)));
        return filiereLangueDtos;
    }
}
