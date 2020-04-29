package org.mustafin.airpark.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.search.util.SearchInputParameters;

import static org.junit.Assert.*;
import org.junit.Before;

public class SearchTest {

	//TODO remove static for each fields
    private Airship airship1;
    private Airship airship2;
    private Airship airship3;
    private Airship airship4;
    private Airship airship5;
    private Airship airship6;

    private AirshipCompany airshipCompany1;
    private AirshipCompany airshipCompany2;

    private List<AirshipCompany> airshipCompanies;

    private SearchInputParameters searchInputParameters;

    private Search search;

    @Before
    public void init() {
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

        search = new Search();
    }

    @Before
    public void cleanSearchInputParameters() {
    	//TODO you have the same line at the end of @Before
        searchInputParameters = new SearchInputParameters();
    }

    @Test
    public void test_proceedByCapacityAndCarrying() { //TODO remove empty line after '{' and before '}' foe each tests
        searchInputParameters.setCapacity(100);
        searchInputParameters.setCarrying(30000);

        List<Airship> expectedFoundAirship = Arrays.asList(airship1, airship6); 
        
        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        //TODO arrange should be before act, below the same

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
    public void test_proceedByDistance() {
        searchInputParameters.setMaxDistance(600);

        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        List<Airship> expectedFoundAirship = Arrays.asList(airship6, airship2, airship1);
        //TODO mixed asserts, rewrite it to three asserts
        assertTrue(expectedFoundAirship.size() == foundArships.size() &&
        		expectedFoundAirship.containsAll(foundArships) &&
        		foundArships.containsAll(expectedFoundAirship));
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
    
    @Test
    public void test_proceedByNameWithNullArgument() {
        searchInputParameters.setName(null);

        List<Airship> foundArships
                = search.proceed(airshipCompanies, searchInputParameters);

        List<Airship> expectedFoundAirship = Collections.EMPTY_LIST;

        assertEquals(expectedFoundAirship, foundArships);
    }
}
