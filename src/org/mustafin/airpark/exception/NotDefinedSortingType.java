//TODO remove signature
package org.mustafin.airpark.exception;
//TODO remove
public class NotDefinedSortingType extends IllegalArgumentException {

    private final static String message = ": Sorting type can not be \"null\"";

    public NotDefinedSortingType() {
    }

    public NotDefinedSortingType(String string) {
        super(string + message);
    }

    public NotDefinedSortingType(String string, Throwable thrwbl) {
        super(string + message, thrwbl);
    }

    public NotDefinedSortingType(Throwable thrwbl) {
        super(thrwbl);
    }

}
