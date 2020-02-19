package org.mustafin.airpark.airshipType;

public enum AirshipType {

    AIRPLANE(), HELICOPTER(), CEPELINE(), AEROSTAT();

    public static AirshipType get(String typeName) {
        return AirshipType.valueOf(typeName); //it won't work if I wrote "Airplane"
    }

}
