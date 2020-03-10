package org.mustafin.airpark.search;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.search.util.SearchInputParameters;

import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void proceed_test() {

        Airship airship1 = new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000);
        Airship airship2 = new Airship("MIG-29", AirshipType.AIRPLANE, 2, 1500, 2500);
        Airship airship3 = new Airship("Messerschmitt", AirshipType.AIRPLANE, 1, 500, 200);
        Airship airship4 = new Airship("IL-2", AirshipType.AIRPLANE, 2, 600, 250);
        Airship airship5 = new Airship("KA-52", AirshipType.HELICOPTER, 2, 750, 300);
        Airship airship6 = new Airship("Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200);

        AirshipCompany airshipCompany1 = new AirshipCompany("Belavia", 10);
        AirshipCompany airshipCompany2 = new AirshipCompany("LuftHansa", 36);

        airshipCompany1.addAirShip(airship1);
        airshipCompany1.addAirShip(airship2);
        airshipCompany1.addAirShip(airship3);

        airshipCompany2.addAirShip(airship4);
        airshipCompany2.addAirShip(airship5);
        airshipCompany2.addAirShip(airship6);

        List<AirshipCompany> airshipCompanies = Arrays.asList(airshipCompany1, airshipCompany2);

        SearchInputParameters searchInputParameters = new SearchInputParameters();
        searchInputParameters.setCapacity(100);
        searchInputParameters.setCarrying(30000);

        Search search = new Search();
        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);
        List<Airship> expectedFoundAirship = Arrays.asList(airship1, airship6);

        assertEquals(expectedFoundAirship, foundArships);

    }
}
