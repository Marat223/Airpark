package org.mustafin.airpark;

import org.mustafin.airpark.annotation.CompanyProxyCreator;
import org.mustafin.airpark.company.AirshipCompany;

public class AirPark {

    private static final String FQN_ORIGINAL = "org.mustafin.airpark.company.AirshipCompany";
    private static final String FQN_PROXY = "org.mustafin.airpark.company.CompanyParametrized";

    public static void main(String[] args) {

//	Functionality functionality = new Functionality();
//	functionality.check();

	AirshipCompany airshipCompany = new AirshipCompany("Belavia", 10);
	CompanyProxyCreator companyReplacer = new CompanyProxyCreator();
	companyReplacer.findMatchedId(FQN_ORIGINAL, FQN_PROXY);
    }

}
