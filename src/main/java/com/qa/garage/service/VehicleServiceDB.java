package com.qa.garage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.garage.data.Vehicle;
import com.qa.garage.dto.VehicleDTO;
import com.qa.garage.exceptions.VehicleNotFoundException;
import com.qa.garage.repo.VehicleRepo;
import com.qa.garage.service.interfaces.VehicleService;

@Primary
@Service
public class VehicleServiceDB implements VehicleService {

	private VehicleRepo repo;

	public VehicleServiceDB(VehicleRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public VehicleDTO mapToDTO(Vehicle vehicle) {
		VehicleDTO dto = new VehicleDTO();
		dto.setAddress(vehicle.getGarage().getAddress());
		dto.setColour(vehicle.getColour());
		dto.setId(vehicle.getId());
		dto.setName(vehicle.getGarage().getName());
		dto.setNoOfWheels(vehicle.getNoOfWheels());
		dto.setType(vehicle.getType());
		return dto;
	}

	@Override
	public List<VehicleDTO> mapToDTO(List<Vehicle> vehicleList) {
		List<VehicleDTO> vehicleDTOList = new ArrayList<>();
		for (Vehicle vehicle : vehicleList) {
			vehicleDTOList.add(mapToDTO(vehicle));
		}
		return vehicleDTOList;
	}

	@Override
	public List<VehicleDTO> findByNoOfWheelsOrColourOrType(Integer noOfWheels, String colour, String type) {
		return mapToDTO(repo.findByNoOfWheelsOrColourOrType(noOfWheels, colour, type));
	}

	@Override
	public List<VehicleDTO> findByNoOfWheels(Integer noOfWheels) {
		return mapToDTO(repo.findByNoOfWheels(noOfWheels));
	}

	@Override
	public List<VehicleDTO> findByColour(String colour) {
		return mapToDTO(repo.findByColour(colour));
	}

	@Override
	public List<VehicleDTO> findByType(String type) {
		return mapToDTO(repo.findByType(type));
	}

	@Override
	public VehicleDTO findByID(Integer id) {
		return mapToDTO(repo.findById(id).orElseThrow(VehicleNotFoundException::new));
	}

	@Override
	public List<VehicleDTO> findAll() {
		return mapToDTO(repo.findAll());
	}

	@Override
	public VehicleDTO create(Vehicle vehicle) {
		return mapToDTO(repo.save(vehicle));
	}

	@Override
	public VehicleDTO update(Vehicle newVehicle, Integer id) {
		Vehicle vehicle = repo.findById(id).orElseThrow(VehicleNotFoundException::new);
		vehicle.setColour(newVehicle.getColour());
		vehicle.setGarage(newVehicle.getGarage());
		vehicle.setNoOfWheels(newVehicle.getNoOfWheels());
		vehicle.setType(newVehicle.getType());
		return mapToDTO(repo.save(vehicle));
	}

	@Override
	public boolean delete(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
