package org.mustafin.airpark.airshipType;

public enum AirshipType {

    AIRPLANE(1), HELICOPTER(2), CEPELINE(3);

    private int order;

    AirshipType(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

}
