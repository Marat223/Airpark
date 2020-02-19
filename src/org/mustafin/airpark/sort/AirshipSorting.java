package org.mustafin.airpark.sort;

import org.mustafin.airpark.airship.AirshipParameterEnum;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.company.AirshipOwner;

public class AirshipSorting {

    public List<Airship> proceed(AirshipOwner company, AirshipParameterEnum sortEnum) throws UnsupportedOperationException {
        Comparator<Airship> comparatorAirship;
        switch (sortEnum) {
            case NAME:
                comparatorAirship = (airship1, airship2) -> airship1.getName().compareTo(airship2.getName());
                return sortAirships(company, comparatorAirship);
            case TYPE:
                comparatorAirship = (airship1, airship2) -> airship1.getType().compareTo(airship2.getType()); // it won't work enough, compareTo() method don't know how to compare AirshipType
                return sortAirships(company, comparatorAirship);
            case CAPACITY:
                comparatorAirship = (airship1, airship2) -> airship1.getType().compareTo(airship2.getType()); //use getCapacity() method
                return sortAirships(company, comparatorAirship);
            case DISTANCE:
                comparatorAirship = (airship1, airship2) -> airship1.getMaxDistance() - airship2.getMaxDistance();
                return sortAirships(company, comparatorAirship);
            default:
                throw new UnsupportedOperationException(); // use default sorting, for ex by name
        }
    }

    private List<Airship> sortAirships(AirshipOwner company, Comparator comparator) {
        Collections.sort(company.getPark(), comparator);
        return company.getPark();
    }
}
