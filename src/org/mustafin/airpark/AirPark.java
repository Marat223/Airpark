package org.mustafin.airpark;

import org.mustafin.airpark.annotation.LastVersionCompanyCreator;
import org.mustafin.airpark.company.AirshipCompany;

public class AirPark {

    public static void main(String[] args) {

//	Functionality functionality = new Functionality();
//	functionality.check();

	AirshipCompany airshipCompany = new AirshipCompany("Belavia", 10);
	LastVersionCompanyCreator<AirshipCompany> companyCreator = new LastVersionCompanyCreator();
	airshipCompany = (AirshipCompany) companyCreator.createInstance(airshipCompany);

    }

}
