package org.mustafin.airpark.item.vehicle;

public abstract class AbstractVehicle {

    private final int id;

    private static int lastId;

    public AbstractVehicle() {
	this.id = lastId++;
    }
    
    public int getId() {
        return id;
    }
}
