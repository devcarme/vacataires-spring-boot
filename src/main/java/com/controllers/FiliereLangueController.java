package com.controllers;

import com.dtos.FiliereLangueDto;
import com.services.FiliereLangueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filiereLangues")
public class FiliereLangueController {
	
	private final FiliereLangueService filiereLangueService;

	public FiliereLangueController(FiliereLangueService filiereLangueService) {
		this.filiereLangueService = filiereLangueService;
	}

	/**
	 * <p>Get all filiereLangue in the system</p>
	 * @return List<FiliereLangueDto>
	 */
	@GetMapping
	public List<FiliereLangueDto> getFiliereLangue() {
		return filiereLangueService.getAllFiliereLangue();
	}

	/**
	 * Method to get the filiereLangue based on the ID
	 */
	@GetMapping("/{id}")
	public FiliereLangueDto getFiliereLangue(@PathVariable Long id){
		return filiereLangueService.getFiliereLangueById(id);
	}

	/**
	 * Create a new FiliereLangue in the system
	 */
	@PostMapping
	public FiliereLangueDto saveFiliereLangue(final @RequestBody FiliereLangueDto filiereLangueDto){
		return filiereLangueService.saveFiliereLangue(filiereLangueDto);
	}

	/**
	 * Delete a filiereLangue by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteFiliereLangue(@PathVariable Long id){
		return filiereLangueService.deleteFiliereLangue(id);
	}
	
}
