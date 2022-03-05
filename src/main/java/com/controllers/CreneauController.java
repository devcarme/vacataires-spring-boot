package com.controllers;

import com.dtos.CreneauDto;
import com.services.CreneauService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creneau")
public class CreneauController {
	
	private final CreneauService creneauService;

	public CreneauController(CreneauService creneauService) {
		this.creneauService = creneauService;
	}

	/**
	 * <p>Get all creneau in the system</p>
	 * @return List<CreneauDto>
	 */
	@GetMapping
	public List<CreneauDto> getCreneau() {
		return creneauService.getAllCreneau();
	}

	/**
	 * Method to get the creneau based on the ID
	 */
	@GetMapping("/{id}")
	public CreneauDto getCreneau(@PathVariable Long id){
		return creneauService.getCreneauById(id);
	}

	/**
	 * Create a new Creneau in the system
	 */
	@PostMapping
	public CreneauDto saveCreneau(final @RequestBody CreneauDto creneauDto){
		return creneauService.saveCreneau(creneauDto);
	}

	/**
	 * Delete a creneau by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteCreneau(@PathVariable Long id){
		return creneauService.deleteCreneau(id);
	}
	
}
