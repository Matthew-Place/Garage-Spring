package com.qa.garage.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;
	private String type;
	private Integer noOfWheels;
	private String colour;

	@ManyToOne
	private Garage garage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNoOfWheels() {
		return noOfWheels;
	}

	public void setNoOfWheels(Integer noOfWheels) {
		this.noOfWheels = noOfWheels;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", type=" + type + ", noOfWheels=" + noOfWheels + ", colour=" + colour
				+ ", garage=" + garage + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, garage, id, noOfWheels, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vehicle)) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		return Objects.equals(colour, other.colour) && Objects.equals(garage, other.garage)
				&& Objects.equals(id, other.id) && Objects.equals(noOfWheels, other.noOfWheels)
				&& Objects.equals(type, other.type);
	}

}
