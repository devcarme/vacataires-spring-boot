package com.services.impl;

import com.dtos.VacataireDto;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import com.services.VacataireService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VacataireServiceImpl implements VacataireService {

    private final VacataireRepository vacataireRepository;

    public VacataireServiceImpl(VacataireRepository vacataireRepository){
                this.vacataireRepository = vacataireRepository;
    }
    /**
     * Map vacataire dto to vacataire entity
     */
    private Vacataire vacataireDtoToEntity(VacataireDto vacataireDto) {
        Vacataire vacataire = new Vacataire();
        vacataire.setLogin(vacataireDto.getLogin());
        vacataire.setMotDePasse(vacataireDto.getMotDePasse());
        vacataire.setNomUsuel(vacataireDto.getNomUsuel());
        vacataire.setPrenom(vacataireDto.getPrenom());
        vacataire.setMail(vacataireDto.getMail());
        vacataire.setId(vacataireDto.getId());
        return vacataire;
    }

    /**
     * Map vacataire entity to vacataire dto
     */
    private VacataireDto vacataireEntityToDto(Vacataire vacataire) {
        VacataireDto vacataireDto = new VacataireDto();
        vacataireDto.setId(vacataire.getId());
        vacataireDto.setLogin(vacataireDto.getLogin());
        vacataireDto.setMotDePasse(vacataireDto.getMotDePasse());
        vacataireDto.setNomUsuel(vacataireDto.getNomUsuel());
        vacataireDto.setPrenom(vacataireDto.getPrenom());
        vacataireDto.setMail(vacataireDto.getMail());
        vacataireDto.setId(vacataireDto.getId());
        return vacataireDto;
    }

    @Override
    public VacataireDto saveVacataire(VacataireDto vacataireDto) {
        // Converts the dto to the dog entity
        Vacataire vacataire = vacataireDtoToEntity(vacataireDto);
        // Save the dog entity
        vacataire = vacataireRepository.save(vacataire);
        // Return the new dto
        return vacataireEntityToDto(vacataire);
    }

    @Override
    public VacataireDto getVacataireById(Long vacataireId) {
        Vacataire vacataire = vacataireRepository.findById(vacataireId).orElseThrow(() -> new EntityNotFoundException("Vacataire not found"));
        return vacataireEntityToDto(vacataire);
    }

    @Override
    public boolean deleteVacataire(Long vacataireId) {
        vacataireRepository.deleteById(vacataireId);
        return true;
    }

    @Override
    public List<VacataireDto> getAllVacataires() {
        List<VacataireDto> vacataireDtos = new ArrayList<>();
        List<Vacataire> vacataire = vacataireRepository.findAll();
        vacataire.forEach(vacataire1 -> vacataireDtos.add(vacataireEntityToDto(vacataire1)));
        return vacataireDtos;
    }
}
