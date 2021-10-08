package com.qa.garage.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;

	@JsonIgnore
	@OneToMany(mappedBy = "garage") // specify the variable name of the FK
	String name;
	String address;

	List<Vehicle> vehicleList = new ArrayList<>();

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

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	@Override
	public String toString() {
		return "Garage [id=" + id + ", name=" + name + ", address=" + address + ", vehicleList=" + vehicleList + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id, name, vehicleList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Garage)) {
			return false;
		}
		Garage other = (Garage) obj;
		return Objects.equals(address, other.address) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(vehicleList, other.vehicleList);
	}

}
