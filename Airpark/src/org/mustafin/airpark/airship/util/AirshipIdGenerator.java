package org.mustafin.airpark.airship.util;

//WTF? you could generate id easier. For ex. static method in class
public enum AirshipIdGenerator {

    INSTANCE;

    private int id;

    public int generateId() {
        return id++;
    }
}
