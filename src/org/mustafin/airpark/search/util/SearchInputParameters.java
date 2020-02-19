//remove signature
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.search.util;

import org.mustafin.airpark.airshipType.AirshipType;

//remove signature
/**
 *
 * @author Marat_Mustafin
 */
public class SearchInputParameters {
	//it would be better to have similar order for getters and setters as fields 
    private String name;
    private AirshipType type;
    private int capacity;
    private int carrying;
    private int maxDistance;

    public SearchInputParameters() {
    }

    public SearchInputParameters(String name, AirshipType type, int capacity, int carrying, int maxDistance) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.carrying = carrying;
        this.maxDistance = maxDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AirshipType getType() {
        return type;
    }

    public void setType(AirshipType type) {
        this.type = type;
    }

}
