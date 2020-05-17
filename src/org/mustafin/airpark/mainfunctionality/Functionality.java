package org.mustafin.airpark.mainfunctionality;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mustafin.airpark.company.AirshipCompany;
import org.mustafin.airpark.exception.NotDefinedSortingType;
import org.mustafin.airpark.item.airship.Airship;
import org.mustafin.airpark.item.airship.AirshipParameterEnum;
import org.mustafin.airpark.itemType.AirshipType;
import org.mustafin.airpark.search.Search;
import org.mustafin.airpark.search.util.SearchInputParameters;
import org.mustafin.airpark.sort.AirshipSorter;

public class Functionality {

    public static void check() {
	Optional<Airship> airship0 = Optional
		.of(new Airship("Bell UH-1 Iroques", AirshipType.HELICOPTER, 12, 1200, 280));
	Optional<Airship> airship1 = Optional.of(new Airship("Aerobus A380", AirshipType.AIRPLANE, 350, 150000, 1600));
	Optional<Airship> airship2 = Optional.of(new Airship("Boeing 737", AirshipType.AIRPLANE, 230, 120000, 1200));
	Optional<Airship> airship3 = Optional.of(new Airship("SuperJet 100", AirshipType.AIRPLANE, 100, 30000, 1000));
	Optional<Airship> airship4 = Optional.of(new Airship("MI-26", AirshipType.HELICOPTER, 40, 20000, 700));
	Optional<Airship> airship5 = Optional.of(new Airship("MIG-29", AirshipType.AIRPLANE, 2, 1500, 2500));
	Optional<Airship> airship6 = Optional.of(new Airship("Messerschmitt", AirshipType.AIRPLANE, 1, 500, 200));
	Optional<Airship> airship7 = Optional.of(new Airship("IL-2", AirshipType.AIRPLANE, 2, 600, 250));
	Optional<Airship> airship8 = Optional.of(new Airship("KA-52", AirshipType.HELICOPTER, 2, 750, 300));
	Optional<Airship> airship9 = Optional.of(new Airship("Hindenburg", AirshipType.CEPELINE, 50, 100000, 1200));

	AirshipCompany airshipOwner1 = new AirshipCompany("Belavia", 10);
	airshipOwner1.addAvaliableitemTypes(AirshipType.HELICOPTER);
	airshipOwner1.addAvaliableitemTypes(AirshipType.AIRPLANE);

	AirshipCompany airshipOwner2 = new AirshipCompany("Lufthansa", 36);
	airshipOwner2.addAvaliableitemTypes(AirshipType.HELICOPTER);
	airshipOwner2.addAvaliableitemTypes(AirshipType.AIRPLANE);

	airshipOwner1.addItem(airship0);
	airshipOwner1.addItem(airship1);
	airshipOwner1.addItem(airship2);
	airshipOwner1.addItem(airship3);
	airshipOwner1.addItem(airship4);
	airshipOwner2.addItem(airship5);
	airshipOwner2.addItem(airship6);
	airshipOwner2.addItem(airship7);
	airshipOwner2.addItem(airship8);
	airshipOwner2.addItem(airship9);

	List<AirshipCompany> airshipOwners = Arrays.asList(airshipOwner1, airshipOwner2);

	SearchInputParameters searchInputParameters = new SearchInputParameters();
	Search search = new Search();

	searchInputParameters.setCapacity(12);
	searchInputParameters.setCarrying(1200);
	List<Airship> foundArships = search.proceed(airshipOwners, searchInputParameters);
	System.out.println("Found airships with capacity >=12 and carryng >=1200:\n" + foundArships);

	searchInputParameters.setCapacity(0);
	searchInputParameters.setCarrying(0);
	searchInputParameters.setType(AirshipType.CEPELINE);
	foundArships = search.proceed(airshipOwners, searchInputParameters);
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
