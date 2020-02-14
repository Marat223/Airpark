/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.sort;

import org.mustafin.airpark.airship.AirshipParameterEnum;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.mustafin.airpark.airship.AbstractAirship;
import org.mustafin.airpark.company.AbstractCompany;

/**
 *
 * @author marat
 */
public class AirshipSorting {

    public List<AbstractAirship> proceed(AbstractCompany company, AirshipParameterEnum sortEnum) throws UnsupportedOperationException {
        Comparator<AbstractAirship> comparatorAirship;
        switch (sortEnum) {
            case NAME:
                comparatorAirship = (airship1, airship2) -> airship1.getName().compareTo(airship2.getName());
                return sortAirships(company, comparatorAirship);
            case TYPE:
                comparatorAirship = (airship1, airship2) -> airship1.getType().compareTo(airship2.getType());
                return sortAirships(company, comparatorAirship);
            case CAPACITY:
                comparatorAirship = (airship1, airship2) -> airship1.getType().compareTo(airship2.getType());
                return sortAirships(company, comparatorAirship);
            case DISTANCE:
                comparatorAirship = (airship1, airship2) -> airship1.getMaxDistance() - airship2.getMaxDistance();
                return sortAirships(company, comparatorAirship);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private List<AbstractAirship> sortAirships(AbstractCompany company, Comparator comparator) {
        Collections.sort(company.getPark(), comparator);
        return company.getPark();
    }
}
