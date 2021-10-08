package com.qa.garage.service;

import java.util.List;

import com.qa.garage.data.Garage;
import com.qa.garage.dto.GarageDTO;

public interface GarageService {

	public GarageDTO mapToDTO(Garage garage);

	public List<GarageDTO> mapToDTO(List<Garage> garageList);

	public List<GarageDTO> findByLocation(String location);

	public List<GarageDTO> findByName(String name);

	public GarageDTO findGarageByID(Integer id);

	public List<GarageDTO> findAllGarages();

	public GarageDTO createGarage(Garage garage);

	public GarageDTO updateGarage(Garage newGarage, Integer id);

	public GarageDTO deleteGarage(Integer id);
}
