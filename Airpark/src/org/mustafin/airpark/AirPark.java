package org.mustafin.airpark;

import java.util.Arrays;
import java.util.List;

import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airship.util.AirshipIdGenerator;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipOwner;
import org.mustafin.airpark.search.Search;
import org.mustafin.airpark.search.util.SearchInputParameters;

public class AirPark {

    public static void main(String[] args) {
        // not informative example of work
        Airship airship0 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "Bell UH-1 Iroques", AirshipType.HELICOPTER, 12, 800, 280);
        Airship airship1 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "Aerobus A380", AirshipType.AIRPLANE, 350, 15000, 1600);
        Airship airship2 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "Boeing 737", AirshipType.AIRPLANE, 230, 12000, 1200);
        Airship airship3 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "SuperJet 100", AirshipType.AIRPLANE, 100, 5000, 1000);
        Airship airship4 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "MI-26", AirshipType.HELICOPTER, 40, 2000, 700);
        Airship airship5 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "IL-76", AirshipType.AIRPLANE, 120, 6000, 1200);

        AirshipOwner airshipOwner1 = new AirshipOwner();
        AirshipOwner airshipOwner2 = new AirshipOwner();

        airshipOwner1.addAirShip(airship0);
        airshipOwner1.addAirShip(airship1);
        airshipOwner1.addAirShip(airship2);
        airshipOwner2.addAirShip(airship3);
        airshipOwner2.addAirShip(airship4);
        airshipOwner2.addAirShip(airship5);

        List<AirshipOwner> airshipOwners = Arrays.asList(airshipOwner1, airshipOwner2);

        SearchInputParameters searchInputParameters = new SearchInputParameters();
        searchInputParameters.setCapacity(120);
        searchInputParameters.setCarrying(6000);

        Search search = new Search();
        List<Airship> foundArships
                = search.proceed(airshipOwners, searchInputParameters);
        System.out.println("Found airships:\n" + foundArships);
    }

    // ADD TESTS
}
