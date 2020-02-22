package org.mustafin.airpark.search;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airship.AirshipParameterEnum;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipOwner;
import org.mustafin.airpark.search.util.SearchInputParameters;

// looks like it isn't finished implementation
public class Search {

    public List<Airship> proceed(List<AirshipOwner> companies, SearchInputParameters searchInputParameters,
            Object value) {
        final List<Airship> foundedAirship = new ArrayList<>();
        EnumSet<AirshipParameterEnum> definedSearchParameters = defineSearchParameters(searchInputParameters);
        boolean match = false;
        for (AirshipParameterEnum definedSearchParameter : definedSearchParameters) {
            switch (definedSearchParameter) {
                case TYPE:
                    for (AirshipOwner company : companies) {
                        for (Airship airship : company.getPark()) {
                            if ((AirshipType) value == airship.getType()) {
                                foundedAirship.add(airship);
                            }
                        }
                    }
                    break;
                case CAPACITY: // ???
                case CARRYING: // ???
                case DISTANCE: // ???
                    findAirshipBySpecificValue(foundedAirship, companies, (int) value);
                    break;
                default:
                    break;
            }
        }
        return foundedAirship;
    }

    private void findAirshipBySpecificValue(final List<Airship> foundedAirship, List<AirshipOwner> companies,
            int value) {
        for (AirshipOwner company : companies) {
            for (Airship airship : company.getPark()) {
                if (value == airship.getCapacity()) {
                    foundedAirship.add(airship);
                }
            }
        }
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
