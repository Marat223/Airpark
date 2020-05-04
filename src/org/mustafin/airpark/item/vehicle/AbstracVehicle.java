package org.mustafin.airpark.item.vehicle;

public abstract class AbstracVehicle {

    private final int id;

    private static int lastId;

    public AbstracVehicle() {
	this.id = lastId++;
    }
    
    public int getId() {
        return id;
    }
}
