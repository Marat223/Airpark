package org.mustafin.airpark.airship;

import java.util.Objects;
import org.mustafin.airpark.airshipType.AirshipType;

public class Airship {

    private final int id;
    private String name;
    private AirshipType type;
    private int capacity;
    private int carrying;
    private int maxDistance;

    private static int lastId;

    public Airship(String name, AirshipType type, int capacity, int carrying, int maxDistance) {
        this.id = lastId++;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.carrying = carrying;
        this.maxDistance = maxDistance;
    }

    public Airship() {
        this.id = lastId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        final Airship other = (Airship) obj;
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
