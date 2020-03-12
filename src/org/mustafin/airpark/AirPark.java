package org.mustafin.airpark;

import java.util.Arrays;
import java.util.List;

import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airship.AirshipParameterEnum;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.exception.NotDefinedSortingType;
import org.mustafin.airpark.search.Search;
import org.mustafin.airpark.search.util.SearchInputParameters;
import org.mustafin.airpark.sort.AirshipSorter;

public class AirPark {

    public static void main(String[] args) {

        Airship airship0 = new Airship("Bell UH-1 Iroques", AirshipType.HELICOPTER, 12, 1200, 280);
        Airship airship1 = new Airship("Aerobus A380", AirshipType.AIRPLANE, 350, 150000, 1600);
        Airship airship2 = new Airship("Boeing 737", AirshipType.AIRPLANE, 230, 120000, 1200);
        Airship airship3 = new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000);
        Airship airship4 = new Airship("MI-26", AirshipType.HELICOPTER, 40, 20000, 700);
        Airship airship5 = new Airship("MIG-29", AirshipType.AIRPLANE, 2, 1500, 2500);
        Airship airship6 = new Airship("Messerschmitt", AirshipType.AIRPLANE, 1, 500, 200);
        Airship airship7 = new Airship("IL-2", AirshipType.AIRPLANE, 2, 600, 250);
        Airship airship8 = new Airship("KA-52", AirshipType.HELICOPTER, 2, 750, 300);
        Airship airship9 = new Airship("Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200);

        AirshipCompany airshipOwner1 = new AirshipCompany("Belavia", 10);
        airshipOwner1.setAvaliableAirshipsTypes(AirshipType.HELICOPTER);
        airshipOwner1.setAvaliableAirshipsTypes(AirshipType.AIRPLANE);

        AirshipCompany airshipOwner2 = new AirshipCompany("Lufthansa", 36);
        airshipOwner2.setAvaliableAirshipsTypes(AirshipType.HELICOPTER);
        airshipOwner2.setAvaliableAirshipsTypes(AirshipType.AIRPLANE);

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

        List<AirshipCompany> airshipOwners = Arrays.asList(airshipOwner1, airshipOwner2);

        SearchInputParameters searchInputParameters = new SearchInputParameters();
        Search search = new Search();

        searchInputParameters.setCapacity(12);
        searchInputParameters.setCarrying(1200);
        List<Airship> foundArships
                = search.proceed(airshipOwners, searchInputParameters);
        System.out.println("Found airships with capacity >=12 and carryng >=1200:\n" + foundArships);

        searchInputParameters.setCapacity(0);
        searchInputParameters.setCarrying(0);
        searchInputParameters.setType(AirshipType.CEPELINE);
        foundArships
                = search.proceed(airshipOwners, searchInputParameters);
        System.out.println("Found airships with type \"cepeline\":\n" + foundArships);

        AirshipSorter airshipSorter = new AirshipSorter();

        List<Airship> sortedAirships = airshipSorter.proceed(airshipOwner2, AirshipParameterEnum.DISTANCE);
        System.out.println("Sorted airships by max. distance:\n" + sortedAirships);

        sortedAirships = airshipSorter.proceed(airshipOwner1, AirshipParameterEnum.CARRYING);
        System.out.println("Sorted airships by carryng:\n" + sortedAirships);

        try {
            sortedAirships = airshipSorter.proceed(airshipOwner2, null);
            System.out.println("Sorted airships without define sorting parameter:\n" + sortedAirships);
        } catch (NotDefinedSortingType notDefinedSortingType) {
            notDefinedSortingType.printStackTrace();
        }
    }

}
