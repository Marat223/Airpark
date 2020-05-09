package org.mustafin.airpark.exception;

public class WrongItemTypeEnumeration extends IllegalArgumentException {
    
    private final static String message = ": The item type must be according its container class";

    public WrongItemTypeEnumeration() {
    }

    public WrongItemTypeEnumeration(String string) {
        super(string + message);
    }

    public WrongItemTypeEnumeration(String string, Throwable thrwbl) {
        super(string + message, thrwbl);
    }

    public WrongItemTypeEnumeration(Throwable thrwbl) {
        super(thrwbl);
    }
}
