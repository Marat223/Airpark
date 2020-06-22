package org.mustafin.airpark.item.vehicle;

import org.mustafin.airpark.item.itemType.VehicleType;

public class Vehicle extends AbstractVehicle {

    private String name;
    private VehicleType type;

    public Vehicle(String name, VehicleType type) {
	super();
	this.name = name;
	this.type = type;
    }
    
    public int getId() {
        return super.getId();
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public VehicleType getType() {
	return type;
    }

    public void setType(VehicleType type) {
	this.type = type;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + super.getId();
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
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
	if (super.getId() != other.getId()) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	if (type != other.type) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Vehicle [id=" + super.getId() + ", name=" + name + ", type=" + type + "]";
    }
}
