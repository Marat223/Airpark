package org.mustafin.airpark.search;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airship.AirshipParameterEnum;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.search.util.SearchInputParameters;

public class Search {

    private boolean matchValue;

    public List<Airship> proceed(List<AirshipCompany> airshipOwners, SearchInputParameters searchInputParameters) {
        final List<Airship> foundedAirship = new ArrayList<>();
        //it is so hard to understand. And I don't understand the sense of this method
        EnumSet<AirshipParameterEnum> definedSearchParameters = defineSearchParameters(searchInputParameters);
        definedSearchParameters.forEach(definedSearchParameter -> {
            airshipOwners.forEach(airshipOwner -> airshipOwner.getParkAirplains().forEach(airship -> {
                switch (definedSearchParameter) {
                    case TYPE:
                        matchValue = airship.getType() == searchInputParameters.getType();
                        break;
                    case AIRSHIP_NAME:
                        matchValue = searchInputParameters.getAirshipName().equals(airship.getName());
                        break;
                    case CAPACITY:
                        matchValue = airship.getCapacity() >= (int) searchInputParameters.getCapacity();
                        break;
                    case CARRYING:
                        matchValue = airship.getCarrying() >= (int) searchInputParameters.getCarrying();
                        break;
                    case DISTANCE:
                        matchValue = airship.getMaxDistance() >= (int) searchInputParameters.getMaxDistance();
                        break;
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
            airshipParameterEnums.add(AirshipParameterEnum.TYPE);
        }
        return airshipParameterEnums;
    }
}
