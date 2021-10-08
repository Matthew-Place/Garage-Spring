package com.qa.garage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.garage.data.Garage;
import com.qa.garage.data.Vehicle;
import com.qa.garage.dto.GarageDTO;
import com.qa.garage.dto.VehicleDTO;
import com.qa.garage.exceptions.GarageNotFoundException;
import com.qa.garage.repo.GarageRepo;
import com.qa.garage.service.interfaces.GarageService;

@Primary
@Service
public class GarageServiceDB implements GarageService {

	private GarageRepo repo;

	public GarageServiceDB(GarageRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public GarageDTO mapToDTO(Garage garage) {
		GarageDTO dto = new GarageDTO();
		dto.setId(garage.getId());
		dto.setAddress(garage.getAddress());
		dto.setName(garage.getName());

		List<VehicleDTO> vehicleDTOList = new ArrayList<>();
		for (Vehicle vehicle : garage.getVehicleList()) {
			VehicleDTO vehicleDTO = new VehicleDTO();
			vehicleDTO.setAddress(vehicle.getGarage().getAddress());
			vehicleDTO.setColour(vehicle.getColour());
			vehicleDTO.setId(vehicle.getId());
			vehicleDTO.setName(vehicle.getGarage().getName());
			vehicleDTO.setNoOfWheels(vehicle.getNoOfWheels());
			vehicleDTO.setType(vehicle.getType());
			vehicleDTOList.add(vehicleDTO);
		}
		dto.setVehicleList(vehicleDTOList);
		return dto;
	}

	@Override
	public List<GarageDTO> mapToDTO(List<Garage> garageList) {
		List<GarageDTO> garageDTOList = new ArrayList<>();
		for (Garage garage : garageList) {
			garageDTOList.add(mapToDTO(garage));
		}
		return garageDTOList;
	}

	@Override
	public List<GarageDTO> findByAddress(String address) {
		return mapToDTO(repo.findByAddress(address));
	}

	@Override
	public List<GarageDTO> findByName(String name) {
		return mapToDTO(repo.findByName(name));
	}

	@Override
	public GarageDTO findByID(Integer id) {
		return mapToDTO(repo.findById(id).orElseThrow(GarageNotFoundException::new));
	}

	@Override
	public List<GarageDTO> findAll() {
		return mapToDTO(repo.findAll());
	}

	@Override
	public GarageDTO create(Garage garage) {
		return mapToDTO(repo.save(garage));
	}

	@Override
	public GarageDTO update(Garage newGarage, Integer id) {
		Garage garage = repo.findById(id).orElseThrow(GarageNotFoundException::new);
		garage.setAddress(newGarage.getAddress());
		garage.setName(newGarage.getName());
		garage.setVehicleList(newGarage.getVehicleList());
		return mapToDTO(repo.save(garage));
	}

	@Override
	public boolean delete(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
}
