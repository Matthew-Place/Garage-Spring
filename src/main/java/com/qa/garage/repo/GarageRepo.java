package com.qa.garage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.garage.data.Garage;

@Repository
public interface GarageRepo extends JpaRepository<Garage, Integer> {

	public List<Garage> findByNameOrAddress(String name, String address);

	public List<Garage> findByAddress(String address);

	public List<Garage> findByName(String name);
}
