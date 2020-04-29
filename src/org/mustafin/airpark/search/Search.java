package org.mustafin.airpark.search;

import java.util.ArrayList;
import java.util.List;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.search.util.SearchInputParameters;

public class Search {

    private boolean matchValue;

    public List<Airship> proceed(List<AirshipCompany> airshipOwners, SearchInputParameters searchInputParameters) {
        final List<Airship> foundedAirship = new ArrayList<>();
        airshipOwners.forEach(airshipOwner -> {
            airshipOwner.getAirshipsPark().forEach(airship -> {
                if (null != searchInputParameters.getType()) {
                    matchValue = airship.getType() == searchInputParameters.getType();
                }
                //TODO no full coverage, add test for it
                if (null != searchInputParameters.getAirshipName() && !"".equals(searchInputParameters.getAirshipName())) {
                    matchValue = searchInputParameters.getAirshipName().equals(airship.getName());
                }
                if (0 != searchInputParameters.getCapacity()) {
                    matchValue = airship.getCapacity() >= (int) searchInputParameters.getCapacity();
                }
                if (0 != searchInputParameters.getCarrying()) {
                    matchValue = airship.getCarrying() >= (int) searchInputParameters.getCarrying();
                }
                if (0 != searchInputParameters.getMaxDistance()) {
                    matchValue = airship.getMaxDistance() >= (int) searchInputParameters.getMaxDistance();
                }
                if (matchValue) {
                    foundedAirship.add(airship);
                }
                matchValue = false;
            });
        });
        return foundedAirship;
    }

}
