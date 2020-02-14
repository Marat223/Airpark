/*
*ADKJH
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.airship;

import java.util.Objects;
import org.mustafin.airpark.airshipType.AirshipType;

/**
 *
 * @author marat
 */
public abstract class AbstractAirship {

    private int id;
    private String name;
    private AirshipType type;
    private int capacity;
    private int carrying;
    private int maxDistance;

    public AbstractAirship(int id, String name, AirshipType type, int capacity, int carrying, int maxDistance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.carrying = carrying;
        this.maxDistance = maxDistance;
    }

    public AbstractAirship() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + this.capacity;
        hash = 59 * hash + this.carrying;
        hash = 59 * hash + this.maxDistance;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractAirship other = (AbstractAirship) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (this.carrying != other.carrying) {
            return false;
        }
        if (this.maxDistance != other.maxDistance) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AbstractAirship{" + "id=" + id + ", name=" + name + ", type=" + type + ", capacity=" + capacity + ", carrying=" + carrying + ", maxDistance=" + maxDistance + '}';
    }
    
}
