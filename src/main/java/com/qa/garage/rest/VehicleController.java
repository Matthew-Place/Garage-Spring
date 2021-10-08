package com.qa.garage.rest;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.qa.garage.data.Vehicle;
import com.qa.garage.dto.VehicleDTO;
import com.qa.garage.service.interfaces.VehicleService;

@RestController
@RequestMapping("/Vehicle")
public class VehicleController {

	private VehicleService service;

	public VehicleController(VehicleService service) {
		super();
		this.service = service;
	}

	@GetMapping("/findByType/{type}")
	public List<VehicleDTO> findByType(@PathVariable String type) {
		return service.findByType(type);
	}

	@GetMapping("/findByNoOfWheels/{noOfWheels}")
	public List<VehicleDTO> findByNoOfWheels(@PathVariable Integer noOfWheels) {
		return service.findByNoOfWheels(noOfWheels);
	}

	@GetMapping("/findByColour/{colour}")
	public List<VehicleDTO> findByColour(@PathVariable String colour) {
		return service.findByColour(colour);
	}

	@GetMapping("/findByID/{id}")
	public VehicleDTO findByID(@PathVariable Integer id) {
		return service.findByID(id);
	}

	@GetMapping("/findByParameters")
	public List<VehicleDTO> getByParameters(@PathParam("noOfWheels") Integer noOfWheels,
			@PathParam("colour") String colour, @PathParam("type") String type) {
		return this.service.findByNoOfWheelsOrColourOrType(noOfWheels, colour, type);
	}

	@GetMapping("/findAll")
	public List<VehicleDTO> findAll() {
		return service.findAll();
	}

	@PostMapping("/create") // 201
	public ResponseEntity<VehicleDTO> create(@RequestBody Vehicle vehicle) {
		return new ResponseEntity<>(service.create(vehicle), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}") // 202 - Accepted
	public ResponseEntity<VehicleDTO> update(@RequestBody Vehicle newVehicle, @PathVariable Integer id) {
		return new ResponseEntity<>(service.update(newVehicle, id), HttpStatus.ACCEPTED);
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
