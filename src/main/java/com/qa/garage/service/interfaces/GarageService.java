package com.qa.garage.service.interfaces;

import java.util.List;

import com.qa.garage.data.Garage;
import com.qa.garage.dto.GarageDTO;

public interface GarageService extends GenericService<GarageDTO, Garage> {

	public List<GarageDTO> findByNameOrAddress(String name, String address);

	public List<GarageDTO> findByAddress(String address);

	public List<GarageDTO> findByName(String name);

}
