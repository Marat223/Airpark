package org.mustafin.airpark.search;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.item.airship.Airship;
import org.mustafin.airpark.itemType.AirshipType;
import org.mustafin.airpark.search.util.SearchInputParameters;

public class SearchTest {

    // TODO remove static for each fields
    private Optional<Airship> airship1;
    private Optional<Airship> airship2;
    private Optional<Airship> airship3;
    private Optional<Airship> airship4;
    private Optional<Airship> airship5;
    private Optional<Airship> airship6;

    private AirshipCompany airshipCompany1;
    private AirshipCompany airshipCompany2;

    private List<AirshipCompany> airshipCompanies;

    private SearchInputParameters searchInputParameters;

    private Search search;

    @Before
    public void init() {
	airship1 = Optional.of(new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000));
	airship2 = Optional.of(new Airship("MIG-29", AirshipType.AIRPLANE, 2, 1500, 2500));
	airship3 = Optional.of(new Airship("Messerschmitt", AirshipType.AIRPLANE, 1, 500, 200));
	airship4 = Optional.of(new Airship("IL-2", AirshipType.AIRPLANE, 2, 600, 250));
	airship5 = Optional.of(new Airship("KA-52", AirshipType.HELICOPTER, 2, 750, 300));
	airship6 = Optional.of(new Airship("Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200));

	airshipCompany1 = new AirshipCompany("Belavia", 10);
	airshipCompany1.addAvaliableitemTypes(AirshipType.AIRPLANE);
	airshipCompany1.addAvaliableitemTypes(AirshipType.HELICOPTER);
	airshipCompany1.addAvaliableitemTypes(AirshipType.CEPELINE);

	airshipCompany2 = new AirshipCompany("LuftHansa", 36);
	airshipCompany2.addAvaliableitemTypes(AirshipType.AIRPLANE);
	airshipCompany2.addAvaliableitemTypes(AirshipType.HELICOPTER);
	airshipCompany2.addAvaliableitemTypes(AirshipType.CEPELINE);

	airshipCompany1.addItem(airship1);
	airshipCompany1.addItem(airship2);
	airshipCompany1.addItem(airship3);

	airshipCompany2.addItem(airship4);
	airshipCompany2.addItem(airship5);
	airshipCompany2.addItem(airship6);

	airshipCompanies = Arrays.asList(airshipCompany1, airshipCompany2);

	search = new Search();
    }

    @Before
    public void cleanSearchInputParameters() {
	// TODO you have the same line at the end of @Before
	searchInputParameters = new SearchInputParameters();
    }

    @Test
    public void test_proceedByCapacityAndCarrying() { // TODO remove empty line after '{' and before '}' foe each tests
	searchInputParameters.setCapacity(100);
	searchInputParameters.setCarrying(30000);

	List<Airship> expectedFoundAirship = Arrays.asList(airship1.get(), airship6.get());

	List<Airship> foundArships = search.proceed(airshipCompanies, searchInputParameters);

	// TODO arrange should be before act, below the same

	assertEquals(expectedFoundAirship, foundArships);
    }

    @Test
    public void test_proceedByCapacity() {
	searchInputParameters.setCapacity(50);

	List<Airship> foundArships = search.proceed(airshipCompanies, searchInputParameters);

	List<Airship> expectedFoundAirship = Arrays.asList(airship1.get(), airship6.get());

	assertEquals(expectedFoundAirship, foundArships);
    }

    @Test
    public void test_proceedByCarrying() {
	searchInputParameters.setCarrying(600);

	List<Airship> foundArships = search.proceed(airshipCompanies, searchInputParameters);

	List<Airship> expectedFoundAirship = Arrays.asList(airship1.get(), airship2.get(), airship4.get(),
		airship5.get(), airship6.get());

	assertEquals(expectedFoundAirship, foundArships);
    }

    @Test
    public void test_proceedByDistance() {
	searchInputParameters.setMaxDistance(600);

	List<Airship> foundArships = search.proceed(airshipCompanies, searchInputParameters);

	List<Airship> expectedFoundAirship = Arrays.asList(airship1.get(), airship2.get(), airship6.get());
	// TODO mixed asserts, rewrite it to three asserts
	assertEquals(expectedFoundAirship, foundArships);
    }

    @Test
    public void test_proceedByType() {
	searchInputParameters.setType(AirshipType.CEPELINE);

	List<Airship> foundArships = search.proceed(airshipCompanies, searchInputParameters);

	List<Airship> expectedFoundAirship = Arrays.asList(airship6.get());

	assertEquals(expectedFoundAirship, foundArships);
    }

    @Test
    public void test_proceedByName() {
	searchInputParameters.setName("IL-2");

	List<Airship> foundArships = search.proceed(airshipCompanies, searchInputParameters);

	List<Airship> expectedFoundAirship = Arrays.asList(airship4.get());

	assertEquals(expectedFoundAirship, foundArships);
    }

    @Test
    public void test_proceedByNameWithNullArgument() {
	searchInputParameters.setName(null);

	List<Airship> foundArships = search.proceed(airshipCompanies, searchInputParameters);

	List<Airship> expectedFoundAirship = Collections.EMPTY_LIST;

	assertEquals(expectedFoundAirship, foundArships);
    }
}
