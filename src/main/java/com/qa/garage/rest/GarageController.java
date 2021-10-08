package com.qa.garage.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.garage.data.Garage;
import com.qa.garage.dto.GarageDTO;
import com.qa.garage.service.interfaces.GarageService;

@RestController
@RequestMapping("/Garage")
public class GarageController {

	private GarageService service;

	public GarageController(GarageService service) {
		super();
		this.service = service;
	}

	@GetMapping("/findByName/{name}")
	public List<GarageDTO> findByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@GetMapping("/findByLocation/{location}")
	public List<GarageDTO> findByLocation(@PathVariable String location) {
		return service.findByLocation(location);
	}

	@GetMapping("/findByID/{id}")
	public GarageDTO findByID(@PathVariable Integer id) {
		return service.findByID(id);
	}

	@GetMapping("/getAll")
	public List<GarageDTO> getAll() {
		return service.findAll();
	}

	@PostMapping("/create") // 201
	public ResponseEntity<GarageDTO> create(@RequestBody Garage garage) {
		return new ResponseEntity<>(service.create(garage), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}") // 202 - Accepted
	public ResponseEntity<GarageDTO> update(@RequestBody Garage newGarage, @PathVariable Integer id) {
		return new ResponseEntity<>(service.update(newGarage, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}") // 204 - No content
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		boolean deleted = this.service.delete(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 causes the body to be ignored
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
