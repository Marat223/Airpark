/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.search;

import java.util.ArrayList;
import java.util.List;
import org.mustafin.airpark.airship.AbstractAirship;
import org.mustafin.airpark.airshipType.AirshipType;

/**
 *
 * @author marat
 */
public class AirshipTypeSearch extends AbstractSearch {

    private AirshipType airshipType;

    public AirshipType getAirshipType() {
        return airshipType;
    }

    public void setAirshipType(AirshipType airshipType) {
        this.airshipType = airshipType;
    }

    public List<AbstractAirship> proceed() {
        List<AbstractAirship> foundedAirship = new ArrayList<>();
//        for (AbstractAirship airship : company.getPark()) {
//            if (airshipType == airship.getType()) {
//                foundedAirship.add(airship);
//            }
//        }
        return foundedAirship;
    }

}
