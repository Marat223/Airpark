/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.search;

import java.util.ArrayList;
import java.util.List;
import org.mustafin.airpark.airship.AbstractAirship;
import org.mustafin.airpark.airship.AirshipParameterEnum;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AbstractCompany;
import org.mustafin.airpark.search.util.SearchInputParameters;

/**
 *
 * @author marat
 */
public class AbstractSearch {

    public List<AbstractAirship> proceed(List<AbstractCompany> companies, SearchInputParameters searchInputParameters, AirshipParameterEnum parameterType, Object value) {
        List<AbstractAirship> foundedAirship = new ArrayList<>();
        switch (parameterType) {
            case TYPE:
                for (AbstractCompany company : companies) {
                    for (AbstractAirship airship : company.getPark()) {
                        if ((AirshipType) value == airship.getType()) {
                            foundedAirship.add(airship);
                        }
                    }
                }
        }
        return foundedAirship;
    }

}
