package org.mustafin.airpark;

import java.util.Arrays;
import java.util.List;

import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airship.AirshipParameterEnum;
import org.mustafin.airpark.airship.util.AirshipIdGenerator;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipOwner;
import org.mustafin.airpark.search.Search;
import org.mustafin.airpark.search.util.SearchInputParameters;
import org.mustafin.airpark.sort.AirshipSorter;

public class AirPark {

    public static void main(String[] args) {
        // not informative example of work
        Airship airship0 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "Bell UH-1 Iroques", AirshipType.HELICOPTER, 12, 1200, 280);
        Airship airship1 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "Aerobus A380", AirshipType.AIRPLANE, 350, 150000, 1600);
        Airship airship2 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "Boeing 737", AirshipType.AIRPLANE, 230, 120000, 1200);
        Airship airship3 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000);
        Airship airship4 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "MI-26", AirshipType.HELICOPTER, 40, 20000, 700);
        Airship airship5 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "MIG-29", AirshipType.AIRPLANE, 2, 1500, 2500);
        Airship airship6 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "Messerschmitt", AirshipType.AIRPLANE, 1, 500, 200);
        Airship airship7 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "IL-2", AirshipType.AIRPLANE, 2, 600, 250);
        Airship airship8 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "KA-52", AirshipType.HELICOPTER, 2, 750, 300);
        Airship airship9 = new Airship(AirshipIdGenerator.INSTANCE.generateId(), "Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200);

        AirshipOwner airshipOwner1 = new AirshipOwner();
        AirshipOwner airshipOwner2 = new AirshipOwner();

        airshipOwner1.addAirShip(airship0);
        airshipOwner1.addAirShip(airship1);
        airshipOwner1.addAirShip(airship2);
        airshipOwner1.addAirShip(airship3);
        airshipOwner1.addAirShip(airship4);
        airshipOwner2.addAirShip(airship5);
        airshipOwner2.addAirShip(airship6);
        airshipOwner2.addAirShip(airship7);
        airshipOwner2.addAirShip(airship8);
        airshipOwner2.addAirShip(airship9);

        List<AirshipOwner> airshipOwners = Arrays.asList(airshipOwner1, airshipOwner2);

        SearchInputParameters searchInputParameters = new SearchInputParameters();
        searchInputParameters.setCapacity(120);
        searchInputParameters.setCarrying(6000);

        //try to test it
        Search search = new Search();
        List<Airship> foundArships
                = search.proceed(airshipOwners, searchInputParameters);
        System.out.println("Found airships:\n" + foundArships);

        AirshipSorter airshipSorter = new AirshipSorter();
        List<Airship> sortedAirships = airshipSorter.proceed(airshipOwner2, AirshipParameterEnum.DISTANCE);
        System.out.println("Sorted airships:\n" + sortedAirships);

    }

    // ADD TESTS
}
