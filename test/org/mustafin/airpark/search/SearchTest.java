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
    public void defineSearchParameters_Test() {

        Airship airship1 = new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000);
        Airship airship2 = new Airship("MIG-29", AirshipType.AIRPLANE, 2, 1500, 2500);
        Airship airship3 = new Airship("Messerschmitt", AirshipType.AIRPLANE, 1, 500, 200);

        AirshipCompany airshipOwner1 = new AirshipCompany();

        airshipOwner1.addAirShip(airship1);
        airshipOwner1.addAirShip(airship2);
        airshipOwner1.addAirShip(airship3);

        List<AirshipCompany> airshipOwners = Arrays.asList(airshipOwner1);

        SearchInputParameters searchInputParameters = new SearchInputParameters();
        searchInputParameters.setCapacity(100);
        searchInputParameters.setCarrying(30000);

        Search search = new Search();
        List<Airship> foundArships
                = search.proceed(airshipOwners, searchInputParameters);
        List<Airship> expectedFoundAirship = Arrays.asList(airship1);

        assertEquals(foundArships, expectedFoundAirship);

    }
}
