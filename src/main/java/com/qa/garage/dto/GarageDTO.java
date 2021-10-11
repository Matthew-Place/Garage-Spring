package com.qa.garage.dto;

import java.util.ArrayList;
import java.util.List;

public class GarageDTO {

	private Integer id;
	private String name;
	private String address;
	List<VehicleDTO> vehicleList = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<VehicleDTO> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<VehicleDTO> vehicleList) {
		this.vehicleList = vehicleList;
	}
}
