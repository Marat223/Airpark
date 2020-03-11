package org.mustafin.airpark.sort;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airship.AirshipParameterEnum;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipCompany;

public class SortTest {

    @Test
    public void sort_test() {
        Airship airship2 = new Airship("KA-52", AirshipType.HELICOPTER, 2, 750, 300);
        Airship airship3 = new Airship("Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200);
        Airship airship1 = new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000);

        AirshipCompany airshipCompany = new AirshipCompany("Belavia", 10);

        airshipCompany.addAirShip(airship1);
        airshipCompany.addAirShip(airship2);
        airshipCompany.addAirShip(airship3);

        AirshipSorter airshipSorter = new AirshipSorter();
        List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.TYPE);

        List<Airship> expectedFoundAirship = Arrays.asList(airship1, airship2, airship3);

        assertEquals(expectedFoundAirship, sortedAirships);
    }
}
