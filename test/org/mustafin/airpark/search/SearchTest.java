package org.mustafin.airpark.search;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.search.util.SearchInputParameters;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class SearchTest {

    private static Airship airship1;
    private static Airship airship2;
    private static Airship airship3;
    private static Airship airship4;
    private static Airship airship5;
    private static Airship airship6;

    private static AirshipCompany airshipCompany1;
    private static AirshipCompany airshipCompany2;

    private static List<AirshipCompany> airshipCompanies;

    private static SearchInputParameters searchInputParameters;

    private static Search search;

    @BeforeClass
    public static void init() {
        airship1 = new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000);
        airship2 = new Airship("MIG-29", AirshipType.AIRPLANE, 2, 1500, 2500);
        airship3 = new Airship("Messerschmitt", AirshipType.AIRPLANE, 1, 500, 200);
        airship4 = new Airship("IL-2", AirshipType.AIRPLANE, 2, 600, 250);
        airship5 = new Airship("KA-52", AirshipType.HELICOPTER, 2, 750, 300);
        airship6 = new Airship("Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200);

        airshipCompany1 = new AirshipCompany("Belavia", 10);
        airshipCompany1.setAvaliableAirshipsTypes(AirshipType.AIRPLANE);
        airshipCompany1.setAvaliableAirshipsTypes(AirshipType.HELICOPTER);
        airshipCompany1.setAvaliableAirshipsTypes(AirshipType.CEPELINE);

        airshipCompany2 = new AirshipCompany("LuftHansa", 36);
        airshipCompany2.setAvaliableAirshipsTypes(AirshipType.AIRPLANE);
        airshipCompany2.setAvaliableAirshipsTypes(AirshipType.HELICOPTER);
        airshipCompany2.setAvaliableAirshipsTypes(AirshipType.CEPELINE);

        airshipCompany1.addAirShip(airship1);
        airshipCompany1.addAirShip(airship2);
        airshipCompany1.addAirShip(airship3);

        airshipCompany2.addAirShip(airship4);
        airshipCompany2.addAirShip(airship5);
        airshipCompany2.addAirShip(airship6);

        airshipCompanies = Arrays.asList(airshipCompany1, airshipCompany2);

        searchInputParameters = new SearchInputParameters();

        search = new Search();
    }

    @After
    public void cleanSearchInputParameters() {
        searchInputParameters = new SearchInputParameters();
    }

    @Test
    public void test_proceedByCapacityAndCarrying() {

        searchInputParameters.setCapacity(100);
        searchInputParameters.setCarrying(30000);

        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        List<Airship> expectedFoundAirship = Arrays.asList(airship1, airship6);

        assertEquals(expectedFoundAirship, foundArships);

    }

    @Test
    public void test_proceedByCapacity() {

        searchInputParameters.setCapacity(50);

        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        List<Airship> expectedFoundAirship = Arrays.asList(airship1, airship6);

        assertEquals(expectedFoundAirship, foundArships);

    }

    @Test
    public void test_proceedByCarrying() {

        searchInputParameters.setCarrying(600);

        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        List<Airship> expectedFoundAirship = Arrays.asList(airship1, airship2, airship4, airship5, airship6);

        assertEquals(expectedFoundAirship, foundArships);

    }

    @Test
//    @Ignore
    public void test_proceedByDistance() {

        searchInputParameters.setMaxDistance(600);

        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        List<Airship> expectedFoundAirship = Arrays.asList(airship6, airship2, airship1);

        assertEquals(expectedFoundAirship, foundArships);

    }

    @Test
    public void test_proceedByType() {

        searchInputParameters.setType(AirshipType.CEPELINE);

        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        List<Airship> expectedFoundAirship = Arrays.asList(airship6);

        assertEquals(expectedFoundAirship, foundArships);

    }
    
    @Test
    public void test_proceedByName() {

        searchInputParameters.setName("IL-2");

        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        List<Airship> expectedFoundAirship = Arrays.asList(airship4);

        assertEquals(expectedFoundAirship, foundArships);

    }
}
