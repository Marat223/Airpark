package org.mustafin.airpark.item.itemType;

public enum AirshipType implements ItemType{

    AIRPLANE(1), HELICOPTER(2), CEPELINE(3);

    private int order;

    AirshipType(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

}
