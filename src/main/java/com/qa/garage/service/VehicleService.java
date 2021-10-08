package com.qa.garage.service;

import java.util.List;

import com.qa.garage.data.Vehicle;
import com.qa.garage.dto.VehicleDTO;

public interface VehicleService extends GenericService<VehicleDTO, Vehicle> {

	public List<VehicleDTO> findByNoOfWheels(Integer noOfWheels);

	public List<VehicleDTO> findByColour(String colour);

	public List<VehicleDTO> findByType(String type);

}
