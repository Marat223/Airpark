package org.mustafin.airpark.sort;

import org.mustafin.airpark.airship.AirshipParameterEnum;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.company.AirshipOwner;

public class AirshipSorter {

    public List<Airship> proceed(AirshipOwner company, AirshipParameterEnum sortEnum) throws UnsupportedOperationException {
        Comparator<Airship> comparatorAirship;
        switch (sortEnum) {
            case TYPE:
                comparatorAirship = (airship1, airship2) -> airship1.getType().getOrder() - airship2.getType().getOrder();
                return sortAirships(company, comparatorAirship);
            case CAPACITY:
                comparatorAirship = (airship1, airship2) -> airship1.getCapacity() - airship2.getCapacity();
                return sortAirships(company, comparatorAirship);
            case DISTANCE:
                comparatorAirship = (airship1, airship2) -> airship1.getMaxDistance() - airship2.getMaxDistance();
                return sortAirships(company, comparatorAirship);
            case CARRYING:
                comparatorAirship = (airship1, airship2) -> airship1.getCarrying() - airship2.getCarrying();
                return sortAirships(company, comparatorAirship);
            case AIRSHIP_NAME:
            default:
                comparatorAirship = (airship1, airship2) -> airship1.getName().compareTo(airship2.getName());
                return sortAirships(company, comparatorAirship);
        }
    }

    private List<Airship> sortAirships(AirshipOwner company, Comparator comparator) {
        Collections.sort(company.getPark(), comparator);
        return company.getPark();
    }
}
