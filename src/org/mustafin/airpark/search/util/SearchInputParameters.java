package org.mustafin.airpark.search.util;

import org.mustafin.airpark.itemType.AirshipType;

public class SearchInputParameters {
	private String airshipName;
	private AirshipType type;
	private int capacity;
	private int carrying;
	private int maxDistance;

	public SearchInputParameters() {
	}

	public SearchInputParameters(Class searchtypeClazz,  String name, AirshipType type, int capacity, int carrying, int maxDistance) {
		this.airshipName = name;
		this.type = type;
		this.capacity = capacity;
		this.carrying = carrying;
		this.maxDistance = maxDistance;
	}

	public String getAirshipName() {
		return airshipName;
	}

	public void setName(String name) {
		this.airshipName = name;
	}

	public AirshipType getType() {
		return type;
	}

	public void setType(AirshipType type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCarrying() {
		return carrying;
	}

	public void setCarrying(int carrying) {
		this.carrying = carrying;
	}

	public int getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

}
