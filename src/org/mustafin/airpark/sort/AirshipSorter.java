package org.mustafin.airpark.sort;

import org.mustafin.airpark.airship.AirshipParameterEnum;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.exception.NotDefinedSortingType;

public class AirshipSorter {

    public List<Airship> proceed(AirshipCompany company, AirshipParameterEnum sortEnum) throws NotDefinedSortingType {
        Comparator<Airship> comparatorAirship;
        try {
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
        } catch (NullPointerException npe) {
            throw new NotDefinedSortingType(npe + ": Airship.proceed()");
        }
    }

    private List<Airship> sortAirships(AirshipCompany company, Comparator comparator) {
        Collections.sort(company.getParkAirplains(), comparator);
        return company.getParkAirplains();
    }
}
