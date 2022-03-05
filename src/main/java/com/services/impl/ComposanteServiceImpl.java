package com.services.impl;

import com.dtos.ComposanteDto;
import com.entities.Composante;
import com.repositories.ComposanteRepository;
import com.services.ComposanteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComposanteServiceImpl implements ComposanteService {

    private final ComposanteRepository composanteRepository;

    public ComposanteServiceImpl(ComposanteRepository composanteRepository){
                this.composanteRepository = composanteRepository;
    }
    /**
     * Map composante dto to composante entity
     */
    private Composante composanteDtoToEntity(ComposanteDto composanteDto) {
        Composante composante = new Composante();
        composante.setNomComposante(composanteDto.getNomComposante());
        composante.setId(composanteDto.getId());
        return composante;
    }

    /**
     * Map composante entity to composante dto
     */
    private ComposanteDto composanteEntityToDto(Composante composante) {
        ComposanteDto composanteDto = new ComposanteDto();
        composanteDto.setId(composante.getId());
        composante.setNomComposante(composanteDto.getNomComposante());
        return composanteDto;
    }

    @Override
    public ComposanteDto saveComposante(ComposanteDto composanteDto) {
        // Converts the dto to the dog entity
        Composante composante = composanteDtoToEntity(composanteDto);
        // Save the dog entity
        composante = composanteRepository.save(composante);
        // Return the new dto
        return composanteEntityToDto(composante);
    }

    @Override
    public ComposanteDto getComposanteById(Long composanteId) {
        Composante composante = composanteRepository.findById(composanteId).orElseThrow(() -> new EntityNotFoundException("Composante not found"));
        return composanteEntityToDto(composante);
    }

    @Override
    public boolean deleteComposante(Long composanteId) {
        composanteRepository.deleteById(composanteId);
        return true;
    }

    @Override
    public List<ComposanteDto> getAllComposante() {
        List<ComposanteDto> composanteDtos = new ArrayList<>();
        List<Composante> composante = composanteRepository.findAll();
        composante.forEach(composante1 -> composanteDtos.add(composanteEntityToDto(composante1)));
        return composanteDtos;
    }
}
