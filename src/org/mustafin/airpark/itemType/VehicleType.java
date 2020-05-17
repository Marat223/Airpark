package org.mustafin.airpark.itemType;

public enum VehicleType implements ItemType{
    
    TYPE1(1), TYPE2(2), TYPE3(3);
    
    private int order;

    VehicleType(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
