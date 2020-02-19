//remove signature
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mustafin.airpark.search;

import java.util.ArrayList;
import java.util.List;
import org.mustafin.airpark.airship.Airship;
import org.mustafin.airpark.airship.AirshipParameterEnum;
import org.mustafin.airpark.airshipType.AirshipType;
import org.mustafin.airpark.company.AbstractCompany;
import org.mustafin.airpark.search.util.SearchInputParameters;

//remove signature
/**
 *
 * @author marat
 */
// looks like it isn't finished implementation
public class Search {

	public List<Airship> proceed(List<AbstractCompany> companies, SearchInputParameters searchInputParameters,
			AirshipParameterEnum parameterType, Object value) {
		final List<Airship> foundedAirship = new ArrayList<>();
		switch (parameterType) {
		case TYPE:
			for (AbstractCompany company : companies) {
				for (Airship airship : company.getPark()) {
					if ((AirshipType) value == airship.getType()) {
						foundedAirship.add(airship);
					}
				}
			}
			break;
		case CAPACITY: // ???
		case CARRYING: // ???
		case DISTANCE: // ???
			findAirshipBySpecificValue(foundedAirship, companies, (int) value);
			break;
		default:
			break;
		}
		return foundedAirship;
	}

	private void findAirshipBySpecificValue(final List<Airship> foundedAirship, List<AbstractCompany> companies,
			int value) {
		for (AbstractCompany company : companies) {
			for (Airship airship : company.getPark()) {
				if (value == airship.getCapacity()) {
					foundedAirship.add(airship);
				}
			}
		}
	}

}
