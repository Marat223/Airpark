package org.mustafin.airpark.airship.util;

public enum AirshipIdGenerator {

    INSTANCE;

    private int id;

    public int generateId() {
        return id++;
    }
}
