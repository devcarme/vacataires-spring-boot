package com.services.impl;

import com.dtos.CoursDto;
import com.entities.Cours;
import com.repositories.CoursRepository;
import com.services.CoursService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoursServiceImpl implements CoursService {

    private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository){
                this.coursRepository = coursRepository;
    }
    /**
     * Map cours dto to cours entity
     */
    private Cours coursDtoToEntity(CoursDto coursDto) {
        Cours cours = new Cours();
        cours.setIntitule(coursDto.getIntitule());
        cours.setId(coursDto.getId());
        return cours;
    }

    /**
     * Map cours entity to cours dto
     */
    private CoursDto coursEntityToDto(Cours cours) {
        CoursDto coursDto = new CoursDto();
        coursDto.setId(cours.getId());
        coursDto.setIntitule(cours.getIntitule());
        return coursDto;
    }

    /**
     * Save cours in database
     * @param coursDto
     * @return CoursDto
     */
    @Override
    public CoursDto saveCours(CoursDto coursDto) {
        // Converts the dto to the dog entity
        Cours cours = coursDtoToEntity(coursDto);
        // Save the dog entity
        cours = coursRepository.save(cours);
        // Return the new dto
        return coursEntityToDto(cours);
    }

    /**
     * Get one cours by id
     * @param coursId
     * @return CoursDto
     */
    @Override
    public CoursDto getCoursById(Long coursId) {
        Cours cours = coursRepository.findById(coursId).orElseThrow(() -> new EntityNotFoundException("Cours not found"));
        return coursEntityToDto(cours);
    }

    /**
     * Delete one cours by id
     * @param coursId
     * @return true
     */
    @Override
    public boolean deleteCours(Long coursId) {
        coursRepository.deleteById(coursId);
        return true;
    }

    /**
     * Get all cours
     * @return CoursDto
     */
    @Override
    public List<CoursDto> getAllCours() {
        List<CoursDto> coursDtos = new ArrayList<>();
        List<Cours> cours = coursRepository.findAll();
        cours.forEach(cours1 -> coursDtos.add(coursEntityToDto(cours1)));
        return coursDtos;
    }
}
