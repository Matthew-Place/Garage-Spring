package com.qa.garage.service;

import java.util.List;

import com.qa.garage.data.Vehicle;
import com.qa.garage.dto.VehicleDTO;

public interface VehicleService {

	public VehicleDTO mapToDTO(Vehicle vehicle);

	public List<VehicleDTO> mapToDTO(List<Vehicle> vehicleList);

	public List<VehicleDTO> findByNoOfWheels(Integer noOfWheels);

	public List<VehicleDTO> findByColour(String colour);

	public List<VehicleDTO> findByType(String type);

	public VehicleDTO findVehicleByID(Integer id);

	public List<VehicleDTO> findAllVehicles();

	public VehicleDTO createVehicle(Vehicle vehicle);

	public VehicleDTO updateVehicle(Vehicle newVehicle, Integer id);

	public VehicleDTO deleteVehicle(Integer id);
}
