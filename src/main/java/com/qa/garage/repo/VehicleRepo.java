package com.qa.garage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.garage.data.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	public List<Vehicle> findByNoOfWheelsOrColourOrType(Integer noOfWheels, String colour, String type);

	public List<Vehicle> findByNoOfWheels(Integer noOfWheels);

	public List<Vehicle> findByColour(String colour);

	public List<Vehicle> findByType(String type);
}
