//remove signature
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mustafin.airpark.airshipType;

import java.util.HashSet;

//remove signature
/**
 *
 * @author marat
 */
public enum AirshipType {

    AIRPLANE(), HELICOPTER(), CEPELINE(), AEROSTAT();
	//set never used, remove it
    private static HashSet<AirshipType> set = new HashSet<>();

    static {
        for (AirshipType typeName : AirshipType.values()) {
            set.add(typeName);
        }
    }

    public static AirshipType get(String typeName) {
        return AirshipType.valueOf(typeName); //it won't work if I wrote "Airplane"
    }

}
