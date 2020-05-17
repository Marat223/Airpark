package org.mustafin.airpark.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.exception.NotDefinedSortingType;
import org.mustafin.airpark.item.airship.Airship;
import org.mustafin.airpark.item.airship.AirshipParameterEnum;
import org.mustafin.airpark.itemType.AirshipType;

public class SortTest {

    // TODO remove static for each fields
    private Optional<Airship> airship2;
    private Optional<Airship> airship3;
    private Optional<Airship> airship1;

    private AirshipCompany airshipCompany;

    private AirshipSorter airshipSorter;

    @Before
    public void init() {
	airship2 = Optional.of(new Airship("KA-52", AirshipType.HELICOPTER, 2, 750, 300));
	airship3 = Optional.of(new Airship("Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200));
	airship1 = Optional.of(new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000));

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
	List<Airship> expectedFoundAirship = Arrays.asList(airship1.get(), airship2.get(), airship3.get());

	List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.TYPE);

	assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test
    public void test_sortByCapacity() {
	List<Airship> expectedFoundAirship = Arrays.asList(airship2.get(), airship3.get(), airship1.get());

	List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.CAPACITY);

	assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test
    public void test_sortByCarring() {
	List<Airship> expectedFoundAirship = Arrays.asList(airship2.get(), airship1.get(), airship3.get());

	List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.CARRYING);

	assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test
    public void test_sortByDistance() {
	List<Airship> expectedFoundAirship = Arrays.asList(airship2.get(), airship1.get(), airship3.get());

	List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.DISTANCE);

	assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test
    public void test_sortByName() {
	List<Airship> expectedFoundAirship = Arrays.asList(airship3.get(), airship2.get(), airship1.get());

	List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.AIRSHIP_NAME);

	assertEquals(expectedFoundAirship, sortedAirships);
    }

    @Test(expected = NotDefinedSortingType.class)
    public void test_sortByNull() {// TODO remove empty lines
	airshipSorter.proceed(airshipCompany, null);
    }
    // TODO add default sort test

    @Test
    public void test_sortByDefault() {
	List<Airship> expectedFoundAirship = Arrays.asList(airship3.get(), airship2.get(), airship1.get());

	List<Airship> sortedAirships = airshipSorter.proceed(airshipCompany, AirshipParameterEnum.STUB_PARAMETER);

	assertEquals(expectedFoundAirship, sortedAirships);
    }
}
