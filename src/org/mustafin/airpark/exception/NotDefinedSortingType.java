/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.exception;

/**
 *
 * @author marat
 */
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
