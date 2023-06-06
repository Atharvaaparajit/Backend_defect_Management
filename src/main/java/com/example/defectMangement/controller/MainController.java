package com.example.defectMangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.defectManagement.entity.Defect;
import com.example.defectManagement.entity.Resolutions;
import com.example.defectMangement.service.DefectService;
import com.example.defectMangement.service.ResolutionService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class MainController {

	@Autowired
	private ResolutionService resolutionService;

	@Autowired
	private DefectService defectService;

	@GetMapping("/demo")
	public String test() {
		return "Hello";
	}

	@PostMapping("/createDefect")
	public ResponseEntity<Defect> createDefect(@RequestBody Defect defect) {
		Defect savedDefect = defectService.createDefect(defect);
		System.out.println(savedDefect);
		return new ResponseEntity<>(savedDefect, HttpStatus.CREATED);
	}
	

	@GetMapping("/getAllDefects")
	public ResponseEntity<List<Defect>> getAllDefects() {
		List<Defect> defects = defectService.getAllDefects();
		return new ResponseEntity<>(defects, HttpStatus.OK);
	}
	
	@GetMapping("/getDefectById/{id}")
	public ResponseEntity<Defect> getDefectById(@PathVariable("id") Long Id) {
		Defect defects = defectService.getDefectById(Id);
		return new ResponseEntity<>(defects, HttpStatus.OK);
	}
	
	@PutMapping("/updateDefect/{id}")
	// http://localhost:8080/api/users/1
	public ResponseEntity<Defect> updateDefect(@PathVariable("id") Long id,
			@RequestBody Defect defect) {
		defect.setDefect_id(id);
		Defect updatedDefect = defectService.updateDefects(defect);
		return new ResponseEntity<>(updatedDefect, HttpStatus.OK);
	}

	@GetMapping("/getDefectByDeveloperId/{id}")
	public ResponseEntity<List<Defect>> getDefectByDeveloperId(@PathVariable("id") String Id) {
		List<Defect> defects = defectService.getDefectByDeveloperId(Id);
		return new ResponseEntity<>(defects, HttpStatus.OK);
	}

	@PostMapping("/createResolution")
	public ResponseEntity<Resolutions> createResolutions(@RequestBody Resolutions resolutions) {
		Resolutions savedResolution = resolutionService.createResolutions(resolutions);
		System.out.println(savedResolution);
		return new ResponseEntity<>(savedResolution, HttpStatus.CREATED);
	}

	// build get user by id REST API
	// http://localhost:8080/api/users/1
	@GetMapping("/getResolutions/{id}")
	public ResponseEntity<Resolutions> geResolutionsById(@PathVariable("id") Long Id) {
		Resolutions resolutions = resolutionService.getResolutionsById(Id);
		return new ResponseEntity<>(resolutions, HttpStatus.OK);
	}

	@GetMapping("/getAllResolutions")
	public ResponseEntity<List<Resolutions>> getAllResolutions() {
		List<Resolutions> resolutions = resolutionService.getAllResolutions();
		return new ResponseEntity<>(resolutions, HttpStatus.OK);
	}


	// Build Update User REST API
	@PutMapping("/update/{id}")
	// http://localhost:8080/api/users/1
	public ResponseEntity<Resolutions> updateResolution(@PathVariable("id") Long id,
			@RequestBody Resolutions resolutions) {
		resolutions.setId(id);
		Resolutions updatedResolutions = resolutionService.updateResolutions(resolutions);
		return new ResponseEntity<>(updatedResolutions, HttpStatus.OK);
	}

	// Build Delete User REST API
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteResolution(@PathVariable("id") Long id) {
		resolutionService.deleteResolutions(id);
		return new ResponseEntity<>("Resoultion successfully deleted!", HttpStatus.OK);
	}


}
