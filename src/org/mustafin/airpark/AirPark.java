package org.mustafin.airpark;

import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.search.Search;

public class AirPark {

	public static void main(String[] args) {
		Airship airship0 = new Airship(0, "Bell UH-1 Iroques", AirshipType.HELICOPTER, 12, 400, 280);
		Airship airship1 = new Airship(1, "Aerobus A380", AirshipType.AIRPLANE, 350, 1500, 1600);
		Airship airship2 = new Airship(2, "Boeing 737", AirshipType.AIRPLANE, 230, 1200, 1200);
		
		Search search = new Search();
	}

}
