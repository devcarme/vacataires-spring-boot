package com.controllers;

import com.dtos.VacataireDto;
import com.services.VacataireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacataires")
public class VacataireController {

	private final VacataireService vacataireService;

	public VacataireController(VacataireService vacataireService) {
		this.vacataireService = vacataireService;
	}

	/**
	 * <p>Get all vacataires in the system</p>
	 * @return List<VacataireDto>
	 */
	@GetMapping
	public List<VacataireDto> getVacataires () {
		return vacataireService.getAllVacataires();
	}

	/**
	 * Method to get the vacataire based on the ID
	 */
	@GetMapping("/{id}")
	public VacataireDto getVacataire(@PathVariable Long id){
		return vacataireService.getVacataireById(id);
	}

	/**
	 * Create a new Vacatairein the system
	 */
	@PostMapping
	public VacataireDto saveVacataire(final @RequestBody VacataireDto vacataireDto){
		return vacataireService.saveVacataire(vacataireDto);
	}

	/**
	 * Delete a vacataire by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteVacataire(@PathVariable Long id){
		return vacataireService.deleteVacataire(id);
	}
}
