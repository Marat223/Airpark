package org.mustafin.airpark.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.exception.NotDefinedSortingType;
import org.mustafin.airpark.item.airship.Airship;
import org.mustafin.airpark.item.airship.AirshipParameterEnum;

public class SortTest {

	//TODO remove static for each fields
    private Airship airship2;
    private Airship airship3;
    private Airship airship1;

    private AirshipCompany airshipCompany;

    private AirshipSorter airshipSorter;

    @Before
    public void init() {
        airship2 = new Airship("KA-52", AirshipType.HELICOPTER, 2, 750, 300);
        airship3 = new Airship("Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200);
        airship1 = new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000);

        airshipCompany = new AirshipCompany("Belavia", 10);
        airshipCompany.addAvaliableitemTypes(AirshipType.AIRPLANE);
        airshipCompany.addAvaliableitemTypes(AirshipType.HELICOPTER);
        airshipCompany.addAvaliableitemTypes(AirshipType.CEPELINE);

        airshipCompany.addItem(airship1);
        airshipCompany.addItem(airship2);
        airshipCompany.addItem(airship3);

        airshipSorter = new AirshipSorter();
    }

    @Test
    public void test_sortByType() {
        List<Airship> expectedFoundAirship = Arrays.asList(airship1, airship2, airship3);

        List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.TYPE);

        assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test
    public void test_sortByCapacity() {
        List<Airship> expectedFoundAirship = Arrays.asList(airship2, airship3, airship1);

        List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.CAPACITY);

        assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test
    public void test_sortByCarring() {
        List<Airship> expectedFoundAirship = Arrays.asList(airship2, airship1, airship3);

        List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.CARRYING);

        assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test
    public void test_sortByDistance() {
        List<Airship> expectedFoundAirship = Arrays.asList(airship2, airship1, airship3);

        List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.DISTANCE);

        assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test
    public void test_sortByName() {
        List<Airship> expectedFoundAirship = Arrays.asList(airship3, airship2, airship1);

        List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.AIRSHIP_NAME);

        assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test(expected = NotDefinedSortingType.class)
    public void test_sortByNull() {//TODO remove empty lines
        airshipSorter.proceed(airshipCompany, null);
    }
    //TODO add default sort test
    
    @Test
    public void test_sortByDefault() {
        List<Airship> expectedFoundAirship = Arrays.asList(airship3, airship2, airship1);

        List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.STUB_PARAMETER);

        assertEquals(expectedFoundAirship, sortedAirships);
    }
}
