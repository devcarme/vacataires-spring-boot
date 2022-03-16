package com.controllers;

import com.dtos.CoursDto;
import com.services.CoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
	
	private final CoursService coursService;

	public CoursController(CoursService coursService) {
		this.coursService = coursService;
	}

	/**
	 * <p>Get all cours in the system</p>
	 * @return List<CoursDto>
	 */
	@GetMapping
	public List<CoursDto> getCours() {
		return coursService.getAllCours();
	}

	/**
	 * Method to get the cours based on the ID
	 */
	@GetMapping("/{id}")
	public CoursDto getCours(@PathVariable Long id){
		return coursService.getCoursById(id);
	}

	/**
	 * Create a new Cours in the system
	 */
	@PostMapping
	public CoursDto saveCours(final @RequestBody CoursDto coursDto){
		return coursService.saveCours(coursDto);
	}

	/**
	 * Delete a cours by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteCours(@PathVariable Long id){
		return coursService.deleteCours(id);
	}
	
}
