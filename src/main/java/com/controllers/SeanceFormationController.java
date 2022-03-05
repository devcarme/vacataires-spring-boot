package com.controllers;

import com.dtos.SeanceFormationDto;
import com.services.SeanceFormationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seanceFormations")
public class SeanceFormationController {
	
	private final SeanceFormationService seanceFormationService;

	public SeanceFormationController(SeanceFormationService seanceFormationService) {
		this.seanceFormationService = seanceFormationService;
	}

	/**
	 * <p>Get all seanceFormation in the system</p>
	 * @return List<SeanceFormationDto>
	 */
	@GetMapping
	public List<SeanceFormationDto> getSeanceFormation() {
		return seanceFormationService.getAllSeanceFormations();
	}

	/**
	 * Method to get the seanceFormation based on the ID
	 */
	@GetMapping("/{id}")
	public SeanceFormationDto getSeanceFormation(@PathVariable Long id){
		return seanceFormationService.getSeanceFormationById(id);
	}

	/**
	 * Create a new SeanceFormation in the system
	 */
	@PostMapping
	public SeanceFormationDto saveSeanceFormation(final @RequestBody SeanceFormationDto seanceFormationDto){
		return seanceFormationService.saveSeanceFormation(seanceFormationDto);
	}

	/**
	 * Delete a seanceFormation by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteSeanceFormation(@PathVariable Long id){
		return seanceFormationService.deleteSeanceFormation(id);
	}
	
}
