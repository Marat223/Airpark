package org.mustafin.airpark.search;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airship.AirshipParameterEnum;
import org.mustafin.airpark.company.AirshipOwner;
import org.mustafin.airpark.search.util.SearchInputParameters;

// looks like it isn't finished implementation
public class Search {

    private boolean matchValue;

    public List<Airship> proceed(List<AirshipOwner> airshipOwners, SearchInputParameters searchInputParameters) {
        final List<Airship> foundedAirship = new ArrayList<>();
        EnumSet<AirshipParameterEnum> definedSearchParameters = defineSearchParameters(searchInputParameters);
        definedSearchParameters.forEach(definedSearchParameter -> {
            airshipOwners.forEach(airshipOwner -> airshipOwner.getPark().forEach(airship -> {
                switch (definedSearchParameter) {
                    case TYPE:
                        matchValue = airship.getType() == searchInputParameters.getType();
                    case AIRSHIP_NAME:
                        matchValue = searchInputParameters.getAirshipName().equals(airship.getName());
                    case CAPACITY:
                        matchValue = airship.getCapacity() == (int) searchInputParameters.getCapacity();
                    case CARRYING:
                        matchValue = airship.getCapacity() == (int) searchInputParameters.getCarrying();
                    case DISTANCE:
                        matchValue = airship.getCapacity() == (int) searchInputParameters.getMaxDistance();
                    default:
                        break;
                }
                if (matchValue) {
                    foundedAirship.add(airship);
                }
                matchValue = false;
            }));
        });
        return foundedAirship;
    }

    private EnumSet<AirshipParameterEnum> defineSearchParameters(SearchInputParameters searchInputParameters) {
        EnumSet<AirshipParameterEnum> airshipParameterEnums = EnumSet.noneOf(AirshipParameterEnum.class);
        if (null != searchInputParameters.getAirshipName() && !"".equals(searchInputParameters.getAirshipName())) {
            airshipParameterEnums.add(AirshipParameterEnum.AIRSHIP_NAME);
        }
        if (0 != searchInputParameters.getCapacity()) {
            airshipParameterEnums.add(AirshipParameterEnum.CAPACITY);
        }
        if (0 != searchInputParameters.getCarrying()) {
            airshipParameterEnums.add(AirshipParameterEnum.CARRYING);
        }
        if (0 != searchInputParameters.getMaxDistance()) {
            airshipParameterEnums.add(AirshipParameterEnum.DISTANCE);
        }
        if (null != searchInputParameters.getType()) {
            airshipParameterEnums.add(AirshipParameterEnum.CAPACITY);
        }
        return airshipParameterEnums;
    }
}
